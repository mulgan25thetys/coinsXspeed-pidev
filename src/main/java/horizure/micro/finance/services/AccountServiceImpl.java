package horizure.micro.finance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import horizure.micro.finance.entities.Account;
import horizure.micro.finance.repositories.AccountRepository;

@Service
public class AccountServiceImpl implements IAccountService{

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public List<Account> retrieveAccounts() {
		return (List<Account>)accountRepository.findAll();
	}

	@Override
	public Account addAccount(Account acc) {
		accountRepository.save(acc);
		return acc;
	}

	@Override
	public Account updateAccount(Account acc) {
		accountRepository.save(acc);
		return acc;
	}

	@Override
	public Account retrieveAccount(Long id) {
		Account acc = accountRepository.findById(id).orElse(null);
		return acc;
	}

	@Override
	public void removeAccount(Long id) {
		accountRepository.deleteById(id);
	}

	
}
