package horizure.micro.finance.repositories;

import org.springframework.stereotype.Repository;

import horizure.micro.finance.entities.Egroup;
import horizure.micro.finance.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	@Query(value = "SELECT sum(amont) FROM TRANSACTION, user, account\r\n"
			+ "				WHERE transaction.account_id_account = account.id_account\r\n"
			+ "				AND  user.user_id = account.user_user_id\r\n"
			+ "			    AND user.egroup = \"Good\"",nativeQuery = true)
	public float getSumAmountByEGroup(@Param("egroup") Egroup egroup);


	 User findOneByuserName(String username);

    @Query(value = "SELECT scoreform_id_score_from FROM user",nativeQuery = true)
    List<Long> getIdForms();
    
    @Query(value = "SELECT *from user WHERE user_name = :username AND email =:email OR email=:email",nativeQuery = true)
    List<User> checkIfUserExist(@Param("username") String username,@Param("email") String email);
}
