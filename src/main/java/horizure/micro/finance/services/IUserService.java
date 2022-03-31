package horizure.micro.finance.services;
import java.util.List;


import horizure.micro.finance.entities.User;

public interface IUserService {
	
	    User retrieveUser (Long userId);
		
		User addUser(User u);            
		
		User updateUser(User u);         
		
		void removeUser(Long userId);

		List<User> retrieveAllUsers();
		
}