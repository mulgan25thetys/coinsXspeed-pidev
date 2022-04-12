package horizure.micro.finance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import horizure.micro.finance.entities.Transaction;
import horizure.micro.finance.services.ITransactionService;

@RestController
@RequestMapping("transaction")
public class TransactionController {

	@Autowired
	ITransactionService itransactionService;
	
	@GetMapping("/list-transactions")
	@ResponseBody
	public List<Transaction> getAllTransactions(){
		return itransactionService.listTransaction();
	}
	
	@PostMapping("/add-transaction")
	@ResponseBody
	public Transaction addTransaction(@RequestBody Transaction t){
		return itransactionService.addTransaction(t);
	}
}
