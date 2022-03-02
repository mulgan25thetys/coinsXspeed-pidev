package horizure.micro.finance.services;

import java.util.List;

import horizure.micro.finance.entities.Privilege;


public interface IPrivilegeService {

	
		
		List<Privilege> retrieveUsers (); /// affichage
		
		Privilege addPrivilege(Privilege p);  /// ajout
		
		Privilege updatePrivilege(Privilege p);  /// modification
		
		Privilege retreivePrivilege(Long id );  //: get 
		

		void removePrivilege(Long id);  /// suppression
		
		
		
	}
	
	
	
	
	
	
	
