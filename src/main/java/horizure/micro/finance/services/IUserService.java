package horizure.micro.finance.services;

import java.util.List;


import horizure.micro.finance.entities.Egroup;
import horizure.micro.finance.entities.User;

public interface IUserService {
	
	
   List<User> retrieveUsers ();     
   
    User getUser(Long userId);

	User addUser(User u);            
	
	User updateUser(User u);         
	
	void removeUser(Long userId);
	
	public float getSumAmountByEGroup( Egroup egroup);
	
}
