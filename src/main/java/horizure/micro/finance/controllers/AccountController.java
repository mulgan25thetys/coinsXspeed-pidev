package horizure.micro.finance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import horizure.micro.finance.entities.Account;
import horizure.micro.finance.services.IAccountService;

@RestController
@RequestMapping("account")
public class AccountController {

	@Autowired
	IAccountService iAccountService;
	
	@GetMapping("/list-accounts")
	@ResponseBody
	public List<Account> getAllAccounts(){
		return iAccountService.retrieveAccounts();
	}
	
	@PostMapping("/add-account/{iduser}")
	@ResponseBody
	public Account addAccount(@RequestBody Account acc,@PathVariable("iduser") Long iduser) {
		return iAccountService.addAccount(acc, iduser);
	}
	
	@PutMapping("/edit-account/{id}")
	@ResponseBody
	public Account editAccount(@PathVariable("id") Long id,@RequestBody Account a) {
		return iAccountService.updateAccount(id,a);
	}
	
	@PutMapping("change-account-status/{idacc}/{value}")
	@ResponseBody
	public ResponseEntity<String> deleteAccount(@PathVariable("idacc") Long idacc,@PathVariable("value") String value) {
		String message=iAccountService.changeAccountStatus(idacc,value) == -1? "Account's status has not been changed!" :"Account's has been changed!";
		return new ResponseEntity<String> (message,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/get-account/{idacc}")
	@ResponseBody
	public Account getAccount(@PathVariable("idacc") Long idacc){
		return iAccountService.retrieveAccount(idacc);
	}
	
	@GetMapping("/get-user-account/{iduser}")
	@ResponseBody
	public Account getUserAccount(@PathVariable("iduser") Long iduser) {
		return iAccountService.getAccountByUser(iduser);
	}
	
	@GetMapping("/sort-accounts/{order}")
	@ResponseBody
	public List<Account> sortAccounts(@PathVariable("order") String order){
		return iAccountService.sortAccount(order);
	}
	
	@GetMapping("/search-accounts/{value}")
	@ResponseBody
	public List<Account> searchAccounts(@PathVariable("value") String value){
		return iAccountService.searchAccount(value);
	}
	
	@GetMapping("/get-statistic")
	@ResponseBody
	public List<String> getStatistic(){
		return iAccountService.statisticAccount();
	}
}
