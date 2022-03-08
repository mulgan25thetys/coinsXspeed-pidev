package horizure.micro.finance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import horizure.micro.finance.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

	
	User findByUserName(String userName);


}
