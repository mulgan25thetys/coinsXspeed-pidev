package horizure.micro.finance.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import horizure.micro.finance.entities.Account;
import horizure.micro.finance.entities.FinancialService;
import horizure.micro.finance.entities.ScoreForm;
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
			ScoreForm form = user.getScoreform();
			//Account userAccount = user.getAccount(); //recuperer le compte de user
			int totalPoints = scoreQuestionRepository.getTotalScore(form.getId_scoreForm()); //recuperer les points totaux du formulaire
			int userScore = user.getAccount().getScore(); //recuperer le score de user
			float pourcentage = (float)userScore / (float)totalPoints; //calculer le pourcentage du score
			
			if(pourcentage >= 0.6 && pourcentage <=1) {
				Account transmitterAccount = accountRepository.getTransmitterAccount(fs.getAmount()); //recupere le compte administrateur debiteur
				if(transmitterAccount != null) {
					user.getAccount().setCapital(user.getAccount().getCapital()+fs.getAmount());
					user.getAccount().setUpdated_at(new Date());
					user.getAccount().getF_services().add(fs);
					
					transmitterAccount.setCapital(transmitterAccount.getCapital() - fs.getAmount()); //debiter le compte de l'administrateur
					
					fs.setTransmitter_id(transmitterAccount.getId_account());
					fs.setCreatedBy_id(user.getUserId());
					fs.setCreated_at(new Date());
				}
			}	
		}
		return fs;
	}

}
