package horizure.micro.finance.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import horizure.micro.finance.entities.Account;
import horizure.micro.finance.entities.CategoryFS;
import horizure.micro.finance.entities.FinancialService;
import horizure.micro.finance.entities.Payement;
import horizure.micro.finance.entities.User;
import horizure.micro.finance.repositories.AccountRepository;
import horizure.micro.finance.repositories.FinancialServiceRepository;
import horizure.micro.finance.repositories.PayementRepository;
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
	
	@Autowired
	IPayementService ipayementService;
	
	@Autowired
	PayementRepository payementRepository;
	
	@Autowired
	EmailService emailService;
	
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
		FS.setDate_of_creation(new Date());
		return financialServiceRepository.save(FS);
	}
	
	
	@Transactional
	public FinancialService addFinancialServiceLoan(long id_ServiceFinancial, long idUser) {
		//long id_ServiceFinancial = FS.getId_ServiceFinancial();	
		User user = userRepository.findById(idUser).orElse(null);
		FinancialService FS = financialServiceRepository.findById(id_ServiceFinancial).orElse(null);
		
		if(user != null && user.getAccount() != null && FS != null) {
			
			List<Payement> paymentList = new ArrayList<>();
			//paymentList =  FS.getPayement();
			
			if(FS.getCategory() == CategoryFS.Loan && user.getAccount().getIsApproved())
			{
				List<FinancialService> lis_fs_acc = financialServiceRepository.getFinancialServiceAccount(user.getAccount().getId_account(), FS.getId_ServiceFinancial());
				if(lis_fs_acc.size() <= 0) {
					user.getAccount().setCapital(user.getAccount().getCapital() + FS.getAmount());
					FS.setDate_of_updating(new Date());
					
					switch (FS.getReimbment_method()) {
					case Mensuality:
						paymentList = ipayementService.getPayement_mensuality(FS.getAmount(), FS.getInterest_pr(), FS.getDuration(), FS.getDate_of_creation());
						for (Payement payement_db : paymentList) {
							payement_db.setFinancialService(FS);
							payement_db.setAccount(user.getAccount());
							FS.getPayement().add(payement_db);
							user.getAccount().getPayments().add(payement_db);
						}
						break;

					default:
						paymentList = ipayementService.getPayement_Block(FS.getAmount(), FS.getInterest_pr(), FS.getDuration(), FS.getDate_of_creation());
						for (Payement payement_db : paymentList) {
							payement_db.setFinancialService(FS);
							payement_db.setAccount(user.getAccount());
							FS.getPayement().add(payement_db);
							user.getAccount().getPayments().add(payement_db);
						}
						break;
					}
					payementRepository.saveAll(paymentList);
					FinancialService fs_return = financialServiceRepository.save(FS);
					accountRepository.save(user.getAccount());
					this.sendEmailAfterLoan(user,fs_return);
				}
			}
			
		}
		return FS;
	}
	
	private void sendEmailAfterLoan(User user,FinancialService fs) {
		String message ="You have souscribe to a loan for "+fs.getAmount()+"DT paid in "+fs.getReimbment_method()+" For more information go to your client space by the link below";
		emailService.sendSimpleMessage(user.getUserName(),user.getEmail(), "Loan Subscription", message, "http://localhost:4200/client-space/payments");
	}
	
	@Transactional
	public FinancialService addFinancialServiceToUserAccount(Long idUser, FinancialService FS) {
/*
		User user = userRepository.findById(idUser).orElse(null);
		
		if(user != null) {
			if(user.getAccount().getIsApproved() && (int)user.getAccount().getFinancialServices().size() <=2) {
				
					user.getAccount().setCapital(user.getAccount().getCapital()+FS.getAmount());
					user.getAccount().setUpdated_at(new Date());
					user.getAccount().getFinancialServices().add(FS);
					List<Account> list_acc = new ArrayList<Account>();
					list_acc.add(user.getAccount());
					FS.setAccounts(list_acc);
					FS.setDate_of_creation(new Date());
					financialServiceRepository.save(FS);
			}	
		}*/
		return null;
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
		
		///FS.setIsAccepted(isAccepted);
		
		financialServiceRepository.save(FS);
		
		return isAccepted ;
	}
	

	@Transactional
	public double getCeilings(FinancialService FS, long id_user) {
		//Account AC = ACRepository.findById(id_account).orElse(null);
		User u = userRepository.findById(id_user).orElse(null);
		double ceilings ;
		
		//int tot_score = scoreQuestionRepository.getTotalScore(u.getScoreform().getId_scoreForm());
		System.out.println("score" + u.getAccount().getScore());
		//float pourcentage_score = ((float)(u.getAccount().getScore()/ (float)tot_score )) * 100 ;
		//double amount = FS.getAmount();
		int score = u.getAccount().getScore();
		
		if((score <= 600) && (score > 300))
		{
			ceilings = 3000 ;
		}
		else if((score < 900) && (score > 600))
		{
			ceilings = 6000 ;
		}
		else if((score == 900))
		{
			ceilings = 10000 ;
		}
		else 
		{
			ceilings = 0 ;
		}
		
		FS.setCeiling(ceilings);
		FS.setDate_of_updating(new Date());
		financialServiceRepository.save(FS) ;
		return ceilings ;
	}

	@Override
	public List<FinancialService> retrieveAccountFinancialService(Long id_account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FinancialService> retrieveAllFinancialServiceAccount(Long id) {
		// TODO Auto-generated method stub
		return (List<FinancialService>)financialServiceRepository.getFinancialServicesForAccount(id);
	}
	

	
	

}