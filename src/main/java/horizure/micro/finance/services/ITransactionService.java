package horizure.micro.finance.services;

import java.util.List;

import horizure.micro.finance.entities.Transaction;

public interface ITransactionService {

	List<Transaction> listTransaction();
	
	Transaction addTransaction(Transaction t);
}
