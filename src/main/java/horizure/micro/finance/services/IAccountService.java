package horizure.micro.finance.services;

import java.util.List;

import horizure.micro.finance.entities.Account;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

public interface IAccountService {

	List<Account> retrieveAccounts ();  
	
	public List<Account> findAllAccounts() ;
	
	Account addAccount(Account account);            
	
	public Account updateAccount(Long id,Account Account) ;

	public Optional <Account> findAccountById(Long id_account);
	

	public Account deleteAccount(Long id_account);
	
	public Account saveAccount(Account newAccount);
}

	

