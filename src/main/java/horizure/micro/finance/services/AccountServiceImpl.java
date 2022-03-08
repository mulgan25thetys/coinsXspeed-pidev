package horizure.micro.finance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import horizure.micro.finance.entities.Account;

import horizure.micro.finance.repositories.AccountRepository;
import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class AccountServiceImpl implements IAccountService{

	@Autowired
	AccountRepository accountRepository;


	@Override
	public List<Account> retrieveAccounts() {
		 return (List<Account>) accountRepository.findAll();
		
	}
	@Override
	public Account addAccount(Account account) {
	   accountRepository.save(account);
	   return account;
	}
	@Override
	public List<Account> findAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Account updateAccount(Long id, Account Account) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Optional<Account> findAccountById(Long id_account) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Account deleteAccount(Long id_account) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Account saveAccount(Account newAccount) {
		// TODO Auto-generated method stub
		return null;
	}
}