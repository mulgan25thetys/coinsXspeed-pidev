package horizure.micro.finance.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import horizure.micro.finance.entities.Account;
import horizure.micro.finance.entities.Transaction;
import horizure.micro.finance.repositories.AccountRepository;
import horizure.micro.finance.repositories.TransactionRepository;
import horizure.micro.finance.repositories.UserRepository;

@Service
public class TransactionServiceImpl implements ITransactionService{

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<Transaction> listTransaction() {
		// TODO Auto-generated method stub
		return (List<Transaction>)transactionRepository.findAll();
	}

	@Transactional
	public Transaction addTransaction(Transaction t) {
		// TODO Auto-generated method stub
		Account accCredit = accountRepository.getAccountByNumber(t.getCreditAcc()); //recuperer le compte à crediter
		
		Account accDebtor = accountRepository.getAccountByNumber(t.getDebtorAcc()); //reuperer le compte a debiter
		
			switch (t.getType()) {
			case  RETRICIVE:
				if(accDebtor !=null && accDebtor.getCapital() > t.getAmont()) {
					accDebtor.setCapital(accDebtor.getCapital() - t.getAmont()); //debiter le compte du debiteur
					
					//accCredit.setCapital(accCredit.getCapital() + t.getAmont()); //crediter le compte du beneficiare
					
					//accDebtor.getTransactions().add(t); //ajouter la transaction au compte debité
					t.setAccount(accDebtor);
					t.setCreated_at(new Date()); //sauvegarder la date d'aujourdhuit
					transactionRepository.save(t); //on sauvegarde la transaction
				}
				break;
			case DEPOSITE:
				if(accCredit !=null && accDebtor !=null && accDebtor.getCapital() > t.getAmont()) {
					accDebtor.setCapital(accDebtor.getCapital() - t.getAmont()); //debiter le compte du debiteur
					
					accCredit.setCapital(accCredit.getCapital() + t.getAmont()); //crediter le compte du beneficiare
					
					//accDebtor.getTransactions().add(t); //ajouter la transaction au compte debité
					t.setCreated_at(new Date()); //sauvegarder la date d'aujourdhuit
					t.setAccount(accDebtor);
					transactionRepository.save(t); //on sauvegarde la transaction
				}else if(t.getDebtorAcc() == null ) {
					accCredit.setCapital(accCredit.getCapital() + t.getAmont()); //crediter le compte du beneficiare
					
					//accCredit.getTransactions().add(t); //ajouter la transaction au compte debité
					t.setCreated_at(new Date()); //sauvegarder la date d'aujourdhuit
					t.setAccount(accCredit);
					transactionRepository.save(t); //on sauvegarde la transaction
				}
				break;
			default:
				break;
			}
		return t;
	}

}
