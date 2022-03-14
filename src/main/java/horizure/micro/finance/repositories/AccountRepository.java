package horizure.micro.finance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import horizure.micro.finance.entities.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long>{
	
	@Query(value= ("SELECT *FROM Account WHERE account_number =:number or user_user_id =:iduser"),nativeQuery = true)
	List<Account> checkAccount(@Param("number") Long number,@Param("iduser") Long iduser);
	
	@Query(value= ("SELECT *FROM Account WHERE user_user_id =:iduser "), nativeQuery = true)
	Account getAccountByUser(@Param("iduser") Long iduser);
	
	@Modifying
	@Query(value =( "update account a set a.score  =:score where a.id_account  =:idaccount"),nativeQuery = true)
	int assynScoreToAccount(@Param("idaccount") Long idaccount,@Param("score") int score);
	
	@Query(value ="SELECT * FROM account ORDER BY score,account_number,capital,created_at,state,type,updated_at ASC",nativeQuery = true)
	List<Account> sortAccountAsc();
	
	@Query(value ="SELECT * FROM account ORDER BY score,account_number,capital,created_at,state,type,updated_at DESC",nativeQuery = true)
	List<Account> sortAccountDesc();
	
	@Query(value = ("SELECT * FROM account a INNER JOIN user u ON a.user_user_id = u.user_id WHERE account_number LIKE %:value% OR score LIKE %:value% OR type LIKE %:value% OR capital LIKE %:value% OR state LIKE %:value% OR a.created_at LIKE %:value% OR a.updated_at LIKE %:value% GROUP BY state,type"),nativeQuery = true)
	List<Account> searchAccount(@Param("value") String value);
}
