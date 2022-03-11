package horizure.micro.finance.services;

import java.util.List;

import horizure.micro.finance.entities.Privilege;


public interface IPrivilegeService {
	
	List<Privilege> retrievePrivileges ();     
	
	Privilege addPrivilege(Privilege p);            
	
	Privilege updatePrivilege(Privilege p);         
	
	void removePrivilege(Long id);
	
	
	
}
