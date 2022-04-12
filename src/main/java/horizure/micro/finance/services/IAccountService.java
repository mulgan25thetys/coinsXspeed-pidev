package horizure.micro.finance.services;

import java.util.Date;
import java.util.List;

import horizure.micro.finance.entities.Account;


public interface IAccountService {

	List<Account> retrieveAccounts(); //affichage
	
	Account addAccount(Account acc,Long iduser); //ajout
	
	Account updateAccount(Long id, Account newAccount); // modification
	
	Account retrieveAccount(Long id); // get un account
	
	int changeAccountStatus(Long id,String value); //suppression
	
	Account getAccountByUser(Long idUser);
	
	List<Account> sortAccount(String order);
	
	List<Account> searchAccount(String value);
	
	List<String> statisticAccount(Date dd,Date df); 
}
