package horizure.micro.finance.services;

import java.util.List;

import horizure.micro.finance.entities.Account;

public interface IAccountService {

	List<Account> retrieveAccounts(); //affichage
	
	Account addAccount(Account acc); //ajout
	
	Account updateAccount(Account acc); // modification
	
	Account retrieveAccount(Long id); // get un account
	
	void removeAccount(Long id); //suppression
}
