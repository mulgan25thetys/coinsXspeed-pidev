package horizure.micro.finance.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import horizure.micro.finance.entities.Account;
import horizure.micro.finance.entities.AccountStatus;
import horizure.micro.finance.entities.User;
import horizure.micro.finance.repositories.AccountRepository;
import horizure.micro.finance.repositories.UserRepository;

@Service
public class AccountServiceImpl implements IAccountService{

	@Autowired
	AccountRepository accountRepository;
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<Account> retrieveAccounts() {
		return (List<Account>)accountRepository.findAll();
	}
	

	@Transactional
	public Account addAccount(Account acc,Long iduser) {
		User user = userRepository.findById(iduser).orElse(null); //récupérer l'utilisateur
		List<Account> accounts = accountRepository.checkAccount(acc.getAccount_number(), iduser); //verifier si le compte existe ou pas
		
		if(accounts.size() == 0 && user != null && user.isOnly()) {
				acc.setUser(user);
				
				acc.setCapital(user.getSalary());
				acc.setScore(0.0);
				acc.setState(AccountStatus.OPENED);
				acc.setCreated_at(new Date());
				acc.setUpdated_at(new Date());
				
				user.setAccount(acc);
				user.setUpdated_at(new Date());
				accountRepository.save(acc);
		}
		
		return acc;
	}

	@Override
	public Account updateAccount(Account acc) {
		return accountRepository.save(acc);
		
	}

	@Override
	public Account retrieveAccount(Long id) {
		Account acc = accountRepository.findById(id).orElse(null);
		return acc;
	}

	@Override
	public int blockAccount(Long id) {
		int result =0;
		Account acc = accountRepository.findById(id).orElse(null);
		if(acc != null) {
			acc.setState(AccountStatus.LOCKED);
			accountRepository.save(acc);
			result = 1;
		}else {
			result = -1;
		}
		return result;
	}

	@Override
	public void assynScoreToAccount(User u) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Account getAccountByUser(Long idUser) {
		// TODO Auto-generated method stub
		return accountRepository.getAccountByUser(idUser);
	}

	
}
