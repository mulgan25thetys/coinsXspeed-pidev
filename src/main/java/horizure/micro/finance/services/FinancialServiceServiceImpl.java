package horizure.micro.finance.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import horizure.micro.finance.entities.FinancialService;
import horizure.micro.finance.entities.User;
import horizure.micro.finance.repositories.AccountRepository;
import horizure.micro.finance.repositories.FinancialServiceRepository;
import horizure.micro.finance.repositories.ScoreQuestionRepository;
import horizure.micro.finance.repositories.UserRepository;

@Service
public class FinancialServiceServiceImpl implements IFinancialServiceService{

	@Autowired
	FinancialServiceRepository financialServiceRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired 
	ScoreQuestionRepository scoreQuestionRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public List<FinancialService> listfinancialService() {
		// TODO Auto-generated method stub
		return (List<FinancialService>)financialServiceRepository.findAll();
	}

	@Transactional
	public FinancialService addFinancialService(Long idUser, FinancialService fs) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(idUser).orElse(null);
		
		if(user != null) {
			if(user.getAccount().getIsApproved() && (int)user.getAccount().getF_services().size() <=2) {
				
					user.getAccount().setCapital(user.getAccount().getCapital()+fs.getAmount());
					user.getAccount().setUpdated_at(new Date());
					user.getAccount().getF_services().add(fs);
					
					fs.setCreated_at(new Date());
					financialServiceRepository.save(fs);
			}	
		}
		return fs;
	}

}
