package horizure.micro.finance.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import horizure.micro.finance.entities.Account;
import horizure.micro.finance.entities.AccountStatus;
import horizure.micro.finance.entities.User;
import horizure.micro.finance.repositories.AccountRepository;
import horizure.micro.finance.repositories.ScoreQuestionRepository;
import horizure.micro.finance.repositories.UserRepository;

@Service
public class AccountServiceImpl implements IAccountService{

	@Autowired
	AccountRepository accountRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ScoreQuestionRepository scoreQuestionRepository;
	
	@Override
	public List<Account> retrieveAccounts() {
		return (List<Account>)accountRepository.findAll();
	}
	

	@Transactional
	public Account addAccount(Account acc,Long iduser) {
		User user = userRepository.findById(iduser).orElse(null); //récupérer l'utilisateur
		Random rand =new Random();
		Long accNumber = Math.abs(rand.nextLong());
		List<Account> accounts = accountRepository.checkAccount(accNumber, iduser); //verifier si le compte existe ou pas
		
		if(accounts.size() == 0 && user != null ) {
				acc.setUser(user);
		
				acc.setAccount_number(accNumber);
				acc.setCapital(0.0);
				acc.setScore(0);
				acc.setState(AccountStatus.OPENED);
				acc.setCreated_at(new Date());
				acc.setUpdated_at(new Date());
				
				user.setAccount(acc);
				user.setUpdated_at(new Date());
				accountRepository.save(acc);
		}
		return acc;
	}

	@Transactional
	public Account updateAccount(Long id,Account newAccount) {
		Account account = accountRepository.findById(id).orElse(null);
		if(account != null) {
			if(newAccount.getAccount_number() != null) {
				account.setAccount_number(newAccount.getAccount_number());
			}else if(newAccount.getType() != null) {
				account.setType(newAccount.getType());
			}else if(newAccount.getState() !=null) {
				account.setState(newAccount.getState());
			}else if(newAccount.getCapital() !=null) {
					 account.setCapital(newAccount.getCapital());
			}
			account.setUpdated_at(new Date());
			accountRepository.save(account);
		
		}	
		
		return account;
	}

	@Override
	public Account retrieveAccount(Long id) {
		Account acc = accountRepository.findById(id).orElse(null);
		return acc;
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
		// TODO Auto-generated method stub
		return accountRepository.getAccountByUser(idUser);
	}


	@Override
	public List<Account> sortAccount(String order) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return accountRepository.searchAccount(value);
	}


	@Override
	public List<String> statisticAccount() {
		List<String> statistic = new ArrayList<>();
		
		int allCapital = accountRepository.availableCapital();
		int borrowedCapital = accountRepository.allBorrowedCapital();
		float borrowedPercentage = ((float)borrowedCapital / (float)allCapital)*100;
		String firstStatisticMessage = "about "+borrowedCapital+" (DT) borrowed capital it represents "+borrowedPercentage+" % of available capital";
		
		float averageScore = accountRepository.averageScore();
		int allPoints = scoreQuestionRepository.allPoints();
		float pointPercentage = (averageScore / (float)(allPoints/scoreQuestionRepository.nbrForm()))*100;
		String secondtStatisticMessage = "Score Average: "+averageScore+" Total score of Forms answered "+allPoints+" about "+pointPercentage+" % of points obtained";
		
		int currentAccountNumber = accountRepository.getCurrentAccountNumber();
		int closedCurrentAccountNumber = accountRepository.getCurrentAccountStateNumber("closed");
		String thirdtStatisticMessage = "Current Account ("+currentAccountNumber+") : closed ("+closedCurrentAccountNumber+") opened ("+accountRepository.getCurrentAccountStateNumber("opened")+") locked ("+accountRepository.getCurrentAccountStateNumber("locked")+")";
		
		//ajout des chaines de message
		statistic.add(firstStatisticMessage);
		statistic.add(secondtStatisticMessage);
		statistic.add(thirdtStatisticMessage);
		return statistic;
	}
}
