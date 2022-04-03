package horizure.micro.finance.services;

import java.util.List;
import java.util.Optional;

import horizure.micro.finance.entities.User;

public interface IUserService {
	
	
	List<User> retrieveUsers ();  
	
	public List<User> findAllUsers() ;
	
	User addUser(User user);            
	
	public User updateUser(Long id,User user) ;

	public Optional <User> findUserById(Long id);
	
	public User findByUserName(String userName);

	public User deleteUser(Long userId);
	
	public User saveUser(User newUser);
	
	
}
