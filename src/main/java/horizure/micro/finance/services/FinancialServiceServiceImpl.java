package horizure.micro.finance.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import horizure.micro.finance.entities.CategoryFS;
import horizure.micro.finance.entities.FinancialService;
import horizure.micro.finance.entities.Payement;
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
	public List<FinancialService> retrieveAllFinancialService() {
		return (List<FinancialService>) financialServiceRepository.findAll();
	}

	@Override
	public FinancialService retrieveFinancialService(Long id) {
		return financialServiceRepository.findById(id).orElse(null);
	}

	@Override
	public FinancialService updateFinancialService(FinancialService FS) {
		return financialServiceRepository.save(FS);
	}
	
	
	@Override
	public FinancialService addFinancialService(FinancialService FS) {
		return financialServiceRepository.save(FS);
	}
	
	
	@Override
	public FinancialService addFinancialServiceLoan(long id_ServiceFinancial, long idUser) {
		//long id_ServiceFinancial = FS.getId_ServiceFinancial();		
		FinancialService FS = financialServiceRepository.findById(id_ServiceFinancial).orElse(null);
		List<Payement> paymentList = new ArrayList<>();
		paymentList =  FS.getPayement();
		
		FS.getCategory();
		if((FS.getCategory().equals(CategoryFS.Loan) ) && (getIsAccepted(id_ServiceFinancial,idUser)) )
		{
			FS.setDate_of_creation(new Date());
			FS.setPayement(paymentList);
		}
		
		financialServiceRepository.save(FS) ;
		
		return FS;
	}
	
	

	@Transactional
	public FinancialService addFinancialServiceToUserAccount(Long idUser, FinancialService FS) {

		User user = userRepository.findById(idUser).orElse(null);
		
		if(user != null) {
			if(user.getAccount().getIsApproved() && (int)user.getAccount().getF_services().size() <=2) {
				
					user.getAccount().setCapital(user.getAccount().getCapital()+FS.getAmount());
					user.getAccount().setUpdated_at(new Date());
					user.getAccount().getF_services().add(FS);
					
					FS.setDate_of_creation(new Date());
					financialServiceRepository.save(FS);
			}	
		}
		return FS;
	}


	@Transactional
	public boolean getIsAccepted(long id_ServiceFinancial, Long idUser) {
		FinancialService FS = financialServiceRepository.findById(id_ServiceFinancial).orElse(null);

		double amount = FS.getAmount();
		boolean isAccepted = false ;
		double cilings = getCeilings(FS,idUser);
		
		if(amount <= cilings)
		{
			isAccepted = true ;
		}
		else
		{
			isAccepted = false;
		}
		
		FS.setIsAccepted(isAccepted);
		
		financialServiceRepository.save(FS);
		
		return isAccepted ;
	}
	

	@Transactional
	public double getCeilings(FinancialService FS, long id_user) {
		//Account AC = ACRepository.findById(id_account).orElse(null);
		User u = userRepository.findById(id_user).orElse(null);
		double ceilings ;
		int tot_score = scoreQuestionRepository.getTotalScore(u.getScoreform().getId_scoreForm());
		System.out.println("score" + tot_score);
		float pourcentage_score = ((float)(u.getAccount().getScore()/ (float)tot_score )) * 100 ;
		//double amount = FS.getAmount();
		
		if((pourcentage_score <= 60) && (pourcentage_score > 50))
		{
			ceilings = 3000 ;
		}
		else if((pourcentage_score <= 80) && (pourcentage_score > 60))
		{
			ceilings = 6000 ;
		}
		else if((pourcentage_score <= 100) && (pourcentage_score > 80))
		{
			ceilings = 10000 ;
		}
		else 
		{
			ceilings = 0 ;
		}
		
		FS.setCeiling(ceilings);
		financialServiceRepository.save(FS) ;
		return ceilings ;
	}
	

	
	

}