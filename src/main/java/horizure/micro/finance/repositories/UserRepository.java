package horizure.micro.finance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import horizure.micro.finance.entities.User;

@Repository

public interface UserRepository extends CrudRepository<User, Long> {
	
	

	User findByUserName(String userName);

    @Query(value = "SELECT scoreform_id_score_from FROM user",nativeQuery = true)
    List<Long> getIdForms();
}
