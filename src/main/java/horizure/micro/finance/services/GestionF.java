package horizure.micro.finance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import horizure.micro.finance.entities.NoFinancialService;
import horizure.micro.finance.entities.User;
import horizure.micro.finance.repositories.NoFinancialRepositry;
import horizure.micro.finance.repositories.UserRepository;
@Service
public class GestionF implements NoFinancialservice {
	@Autowired
	NoFinancialRepositry financialRepositry;
	@Autowired
	UserRepository repository;

	@Override
	public List<NoFinancialService> getAll() {
		// TODO Auto-generated method stub
		return financialRepositry.findAll();
	}

	@Override
	public NoFinancialService addNoFinancialService(NoFinancialService f) {
		// TODO Auto-generated method stub
		return financialRepositry.save(f);
	}

	@Override
	public List<NoFinancialService> getByoFinancialServiceUser(Long userid) {
	User u= repository.findById(userid).orElse(null);
	 return financialRepositry.getoFinancialServiceByUser(userid);
		
	}

	@Override
	public NoFinancialService updateNoFinancialService(NoFinancialService f) {
		// TODO Auto-generated method stub
		return financialRepositry.save(f);
	}

	

}
