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
	
	@Query(value= ("SELECT *FROM Account WHERE user_id_user =:iduser "), nativeQuery = true)
	Account getAccountByUser(@Param("iduser") Long iduser);
	
	@Modifying
	@Query(value = "update account a set a.score  =:score where a.id_account  =:idaccount",nativeQuery = true)
	int assynScoreToAccount(@Param("idaccount") Long idaccount,@Param("score") int score);
	
}
