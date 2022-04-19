package horizure.micro.finance.services;

import java.util.List;


import horizure.micro.finance.entities.Egroup;
import horizure.micro.finance.entities.User;

public interface IUserService {
	    
   
    User getUser(Long userId);

	List<User> retrieveUsers();  
	
	public List<User> findAllUsers() ;     
	
	User addUserWithAccount(User user);   
	
	public User updateUser(Long id,User user) ;

	User addUser(User u);            
	
	User updateUser(User u);         
	
	void removeUser(Long userId);
	
	public float getSumAmountByEGroup( Egroup egroup);
	
}
