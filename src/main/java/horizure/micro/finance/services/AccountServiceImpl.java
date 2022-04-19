package horizure.micro.finance.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import horizure.micro.finance.entities.Account;
import horizure.micro.finance.entities.AccountStatus;
import horizure.micro.finance.entities.AccountType;
import horizure.micro.finance.entities.StLevel;
import horizure.micro.finance.entities.Status;
import horizure.micro.finance.entities.User;
import horizure.micro.finance.repositories.AccountRepository;
import horizure.micro.finance.repositories.ScoreQuestionRepository;
import horizure.micro.finance.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AccountServiceImpl implements IAccountService{

	@Autowired
	AccountRepository accountRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ScoreQuestionRepository scoreQuestionRepository;
	
	private Random rand =new Random();
	@Override
	public List<Account> retrieveAccounts() {
		return (List<Account>)accountRepository.findAllDESC();
	}
	

	@Transactional
	public Account addAccount(Account acc,Long iduser) {
		User user = userRepository.findById(iduser).orElse(null); //récupérer l'utilisateur
		
		Long accNumber = Math.abs(rand.nextLong());
		List<Account> accounts = accountRepository.checkAccount(accNumber, iduser); //verifier si le compte existe ou pas
		
		if(accounts.size() == 0 && user != null ) {
				acc.setUser(user);
		
				acc.setAccount_number(accNumber);
				acc.setCapital(0.0);
				acc.setScore(0);
				acc.setIsApproved(false);
				acc.setState(AccountStatus.OPENED);
				acc.setCreated_at(new Date());
				acc.setUpdated_at(new Date());
				
				user.setAccount(acc);
				user.setUpdated_at(new Date());
				accountRepository.save(acc);
		}
		log.trace("Creation de compte : Numero ="+acc.getAccount_number());
		return acc.getId_account() == null ? null:acc;
	}

	@Transactional
	public Account updateAccount(Long id,Account newAccount) {
		Account account = accountRepository.findById(id).orElse(null);
		if(account != null) {
			if(newAccount.getType() != null ) {
				account.setType(newAccount.getType());
			}
			if(newAccount.getState() !=null) {
				account.setState(newAccount.getState());
			}	
			account.setUpdated_at(new Date());
			accountRepository.save(account);
		}	
		return account;
	}

	@Override
	public Account retrieveAccount(Long id) {
		return  accountRepository.findById(id).orElse(null);
	}

	@Override
	public int changeAccountStatus(Long id,String value) {
		int result =0;
		Account acc = accountRepository.findById(id).orElse(null);
		if(acc != null) {
			switch (value) {
			case "closed":
				acc.setState(AccountStatus.CLOSED);		
				break;
			case "locked":
				acc.setState(AccountStatus.LOCKED);
				break;
			default:
				acc.setState(AccountStatus.OPENED);
				break;
			}
			accountRepository.save(acc);
			result = 1;
		}else {
			result = -1;
		}
		return result;
	}

	@Override
	public Account getAccountByUser(Long idUser) {
		return accountRepository.getAccountByUser(idUser);
	}

	@Override
	public List<Account> sortAccount(String order) {
		List<Account> list;
		switch (order) {
		case "asc":
			list=accountRepository.sortAccountAsc();
			break;
		case "desc":
			list=accountRepository.sortAccountDesc();
			break;
		default:
			list=accountRepository.sortAccountDesc();
			break;
		}
		return list;
	}

	@Override
	public List<Account> searchAccount(String value) {
		return accountRepository.searchAccount(value);
	}

	@Override
	public List<String> statisticAccount(Date dd,Date df) {
		List<String> statistics = new ArrayList<>();
		
		if(dd ==null && df == null) {
			try {
				dd = new SimpleDateFormat("yyyy-MM-dd").parse("1970-01-01");
				df = new Date();
			} catch (ParseException e) {
				e.printStackTrace();
			} 
			statistics = setMessage(statistics, dd, df);
		}else {
			statistics = setMessage(statistics, dd, df);
		}	
		return statistics;
	}
	
	List<String> setMessage(List<String> statistic,Date dd,Date df){
		String firstStatisticMessage = "Null";
		String secondtStatisticMessage = "Null";
		String thirdtStatisticMessage = "Null";
		
		int allCapital = accountRepository.availableCapital(dd,df);
		int borrowedCapital = accountRepository.allBorrowedCapital(dd,df);
		float borrowedPercentage = allCapital == 0 ?0:((float)borrowedCapital / (float)allCapital)*100;
	    firstStatisticMessage = "about "+borrowedCapital+" (DT) borrowed capital it represents "+borrowedPercentage+" % of available capital";
		
		float averageScore = accountRepository.averageScore(dd,df);
		int allPoints = scoreQuestionRepository.allPoints();
		float pointPercentage = (averageScore / (float)(allPoints/scoreQuestionRepository.nbrForm()))*100;
		secondtStatisticMessage = "Score Average: "+averageScore+" Total score of Forms answered "+allPoints+" about "+pointPercentage+" % of points obtained";
		
		int currentAccountNumber = accountRepository.getCurrentAccountNumber(dd,df);
		int closedCurrentAccountNumber = accountRepository.getCurrentAccountStateNumber("closed",dd,df);
		thirdtStatisticMessage = "Current Account ("+currentAccountNumber+") : closed ("+closedCurrentAccountNumber+") opened ("+accountRepository.getCurrentAccountStateNumber("opened",dd,df)+") locked ("+accountRepository.getCurrentAccountStateNumber("locked",dd,df)+")";
		
		//ajout des chaines de message
		statistic.add(firstStatisticMessage);
		statistic.add(secondtStatisticMessage);
		statistic.add(thirdtStatisticMessage);
		log.info("Account statistic");
		return statistic;
	}
	
	//@Scheduled(fixedDelay = 5000)
	@Scheduled(cron = "0 0 0 * * *")
	@Transactional
	public void classifyAccounts() {
		log.debug("Starting for mining in Account entity!");
		List<Account> accounts = accountRepository.getAccountForMining();
		
		for (Account account : accounts) {//parcourir les comptes
			if(account.getUser().getAge() >=22 && account.getUser().getAge()<=28) {
					account = this.classTheAccount(account); //classer le compte pour la tranche d'age 22 - 28
			}
			else if(account.getUser().getAge() >=28 && account.getUser().getAge()<=34) {
					account = this.classTheAccount(account);//classer le compte pour la tranche d'age 28 - 34
			}
			else if(account.getUser().getAge() >=34 && account.getUser().getAge()<=40) {
					account = this.classTheAccount(account);//classer le compte pour la tranche d'age 34 - 40
			}
			account.setUpdated_at(new Date());
			if(account.getAccount_number() == null) {
				account.setAccount_number(Math.abs(rand.nextLong()));
			}
			accountRepository.save(account);
			System.out.println(account);
		}
	}
	
	public Account classTheAccount(Account account) { //retourne le compte classé apres traitement
		if (account.getUser().getLevel() == StLevel.student) {
			account = this.studentClass(account);
		}
		else if(account.getUser().getLevel() == StLevel.professionnal) {
			account = this.professionnalClass(account);
		}
		else if(account.getUser().getLevel() == StLevel.none) {
			account = this.noneClass(account);
		}
		else {
			account.setScore(900);
			account.setIsApproved(true);
		}
		return account;
	}
	
	public Account professionnalClass(Account account) { //traitement pour le compte professionnel
		if(account.getUser().getSalary() >=0 && account.getUser().getSalary()<=500) {
			account.setScore(900);
			account.setIsApproved(true);
		}else if (account.getUser().getSalary() >=500 && account.getUser().getSalary()<=1000) {
			account.setScore(600);
			account.setIsApproved(true);
		}
		return account;
	}
	
	public Account studentClass(Account account) {//traitement pour le compte etudiant
		if(account.getUser().getStatus() ==Status.CONFIRME) {
			account.setScore(900);
			account.setIsApproved(true);
		}else if (account.getUser().getStatus() ==Status.PASCONFIRME) {
			account.setScore(300);
			account.setIsApproved(false);
		}
		return account;
	}
	
	public Account noneClass(Account account) { //traitement pour le compte non professionnel
		if(account.getUser().getStatus() ==Status.CONFIRME && account.getType() == AccountType.CURRENT) {
			account.setScore(600);
			account.setIsApproved(true);
		}else if (account.getUser().getStatus() ==Status.PASCONFIRME) {
			account.setScore(300);
			account.setIsApproved(false);
		}
		return account;
	}
}
