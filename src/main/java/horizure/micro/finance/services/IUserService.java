package horizure.micro.finance.services;

import java.util.List;

import horizure.micro.finance.entities.User;

public interface IUserService {
	
	List<User> retrieveUsers ();     /// affichage de user
	
	User addUser(User u);            /// ajouter  un  utilisateur 
	
	User updateUser(User u);         /// modification d'un utilisateur
	
	void removeUser(Long id);        /// suppression d'un utilisateur
	
	
	
}
