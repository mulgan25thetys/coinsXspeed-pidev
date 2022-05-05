package horizure.micro.finance.repositories;

import java.util.Date;
import java.util.List;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import horizure.micro.finance.entities.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long>{
	
	@Query(value= ("SELECT *FROM Account order by created_at desc"),nativeQuery = true)
	List<Account> findAllDESC();
	
	@Query(value= ("SELECT *FROM Account WHERE account_number =:number or user_user_id =:iduser"),nativeQuery = true)
	List<Account> checkAccount(@Param("number") Long number,@Param("iduser") Long iduser);
	
	@Query(value= ("SELECT *FROM Account WHERE user_user_id =:iduser "), nativeQuery = true)
	Account getAccountByUser(@Param("iduser") Long iduser);
	
	@Modifying
	@Query(value =( "update account a set a.score  =:score,a.is_approved=:approved where a.id_account  =:idaccount"),nativeQuery = true)
	int assynScoreToAccount(@Param("idaccount") Long idaccount,@Param("score") int score,@Param("approved") Boolean approved);
	
	@Query(value ="SELECT * FROM account ORDER BY score,account_number,capital,created_at,state,type,updated_at ASC",nativeQuery = true)
	List<Account> sortAccountAsc();
	
	@Query(value ="SELECT * FROM account ORDER BY score,account_number,capital,created_at,state,type,updated_at DESC",nativeQuery = true)
	List<Account> sortAccountDesc();
	
	@Query(value = ("SELECT * FROM account a INNER JOIN user u ON a.user_user_id = u.user_id WHERE u.user_name LIKE %:value% OR account_number LIKE %:value% OR score LIKE %:value% OR type LIKE %:value% OR capital LIKE %:value% OR state LIKE %:value% OR a.created_at LIKE %:value% OR a.updated_at LIKE %:value% GROUP BY state,type"),nativeQuery = true)
	List<Account> searchAccount(@Param("value") String value);
	
	@Query(value = "SELECT id_account,capital FROM account INNER JOIN user ON account.user_user_id = user.user_id WHERE user.role = 'ADMIN' AND account.capital >=:amont ORDER BY account.capital DESC LIMIT 1",nativeQuery = true)
	Account getTransmitterAccount(@PathVariable("amont") Double amont);
	
	@Query(value ="SELECT *FROM Account WHere account_number=:numberacc ",nativeQuery = true)
	Account getAccountByNumber(@Param("numberacc") Long numberacc);
	
	@Query(value = "SELECT CASE WHEN SUM(capital) IS NULL THEN 0 ELSE SUM(capital) END FROM account WHERE user_user_id in (SELECT user_id FROM user WHERE role = 'ADMIN') AND created_at BETWEEN :dated AND :datef",nativeQuery = true)
	int availableCapital(@Param("dated") Date dated,@Param("datef") Date datef);
	
	@Query(value = "SELECT CASE WHEN SUM(capital) IS NULL THEN 0 ELSE SUM(capital) END FROM account WHERE user_user_id NOT in (SELECT user_id FROM user WHERE role = 'ADMIN') AND created_at BETWEEN :dated AND :datef",nativeQuery = true)
	int allBorrowedCapital(@Param("dated") Date dated,@Param("datef") Date datef);
	
	@Query(value = "SELECT CASE WHEN AVG(score) IS NULL THEN 0 ELSE AVG(score) END FROM account WHERE created_at BETWEEN :dated AND :datef",nativeQuery = true)
	float averageScore(@Param("dated") Date dated,@Param("datef") Date datef);
	
	@Query(value = "SELECT COUNT(*) nbr FROM account WHERE type = 'current' AND created_at BETWEEN :dated AND :datef ",nativeQuery = true)
	int getCurrentAccountNumber(@Param("dated") Date dated,@Param("datef") Date datef);
	
	@Query(value = "SELECT COUNT(*) nbr FROM account WHERE type = 'current' AND state=:value AND created_at BETWEEN :dated AND :datef",nativeQuery = true)
	int getCurrentAccountStateNumber(@Param("value") String value,@Param("dated") Date dated,@Param("datef") Date datef);
	
	@Query(value = "SELECT * FROM account a "
			+ "INNER JOIN user u ON a.user_user_id = u.user_id "
			+ "WHERE u.status != 'bannit' AND u.role = 'client' ",nativeQuery = true)
	List<Account> getAccountForMining();
	
	@Query(value = "SELECT account_number FROM account WHERE 1",nativeQuery = true)
	List<Long> getAccountNumber();
}

