package horizure.micro.finance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import horizure.micro.finance.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	
	User findByUserName(String userName);

    @Query(value = "SELECT scoreform_id_score_from FROM user",nativeQuery = true)
    List<Long> getIdForms();
    
    @Query(value = "SELECT *from user WHERE user_name = :username AND email =:email OR email=:email",nativeQuery = true)
    List<User> checkIfUserExist(@Param("username") String username,@Param("email") String email);
    
}
