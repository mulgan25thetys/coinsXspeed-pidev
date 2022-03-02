package horizure.micro.finance.services;

import java.util.List;

import horizure.micro.finance.entities.User;

public interface IUserService {
	
	List<User> retrieveUsers (); /// affichage
	
	User addUser(User u);  /// ajout
	
	User updateUser(User u);  /// modification
	
	User retreiveUser(Long id );  //: get un account
	

	void removeUser(Long id);  /// suppression
	
	
	
}
