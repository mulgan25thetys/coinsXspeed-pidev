package horizure.micro.finance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import horizure.micro.finance.entities.Privilege;
import horizure.micro.finance.repositories.PrivilegeRepository;


@Service
public class PrivilegeServiceImpl implements IPrivilegeService {
	
	@Autowired
	PrivilegeRepository privilegeRepository;

	@Override
	public List<Privilege> retrieveUsers() {
		 return (List<Privilege>) privilegeRepository.findAll();
		
	}

	@Override
	public Privilege addPrivilege(Privilege p) {
	   privilegeRepository.save(p);
	   return p;
		
	}

	@Override
	public Privilege updatePrivilege(Privilege p) {
	  privilegeRepository.save(p);
	  return p;
	}

	@Override
	public Privilege retreivePrivilege(Long id) {
		
		 Privilege p =privilegeRepository.findById(id).orElse(null);
		 return p;
}

	@Override
	public void removePrivilege(Long id) {
		privilegeRepository.deleteById(id);
		
	}



}
