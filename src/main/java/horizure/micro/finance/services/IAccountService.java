package horizure.micro.finance.services;

import java.util.List;

import horizure.micro.finance.entities.Account;
import horizure.micro.finance.entities.User;

public interface IAccountService {

	List<Account> retrieveAccounts(); //affichage
	
	Account addAccount(Account acc,Long iduser); //ajout
	
	Account updateAccount(Account acc); // modification
	
	Account retrieveAccount(Long id); // get un account
	
	int blockAccount(Long id); //suppression
	
	void assynScoreToAccount(User u);
	
	Account getAccountByUser(Long idUser);
}
