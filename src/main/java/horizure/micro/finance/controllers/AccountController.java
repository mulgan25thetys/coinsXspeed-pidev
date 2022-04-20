package horizure.micro.finance.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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

import horizure.micro.finance.apis.AccountExcelExporter;
import horizure.micro.finance.entities.Account;
import horizure.micro.finance.entities.User;
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
	
	@PutMapping("/change-account-status/{idacc}/{value}")
	@ResponseBody
	public ResponseEntity<String> deleteAccount(@PathVariable("idacc") Long idacc,@PathVariable("value") String value) {
		String message=iAccountService.changeAccountStatus(idacc,value) == -1? "Account's status has not been changed to "+value :"Account's has been changed!";
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
	
	@GetMapping("/get-statistic-by-date/{dated}/{datef}")
	@ResponseBody
	public List<String> getStatisticByDate(@PathVariable("dated") String sDate1,@PathVariable("datef") String sDate2){
		Date dated = null,datef = null;
		try {
			dated = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
			datef = new SimpleDateFormat("yyyy-MM-dd").parse(sDate2); 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		 
		return iAccountService.statisticAccount(dated,datef);
	}
	
	@GetMapping("/get-statistic")
	@ResponseBody
	public List<String> getStatistic(){
		return iAccountService.statisticAccount(null,null);
	}
	
	@GetMapping("/export/excel")
	public void exportToExcel(HttpServletResponse response) throws IOException {
	    response.setContentType("application/octet-stream");
	    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	    String currentDateTime = dateFormatter.format(new Date());
	         
	    String headerKey = "Content-Disposition";
	    String headerValue = "attachment; filename=accounts_" + currentDateTime + ".xlsx";
	    response.setHeader(headerKey, headerValue);
	         
	    List<Account> listAccounts = iAccountService.retrieveAccounts();
	         
	    AccountExcelExporter excelExporter = new AccountExcelExporter(listAccounts);
	         
	    excelExporter.export(response);    
	}
	@GetMapping("/get-all-clients")
	@ResponseBody
	public List<User> getClient(){
		return iAccountService.getClient();
	}
	
	@GetMapping("/get-user-by-account/{id_acc}")
	@ResponseBody
	public User getUserByAccount(@PathVariable("id_acc") Long id)
	{
		return iAccountService.getUserByAccount(id);
	}
	
	@GetMapping("/get-account-by-user/{id_us}")
	@ResponseBody
	public Account getAccountByUser(@PathVariable("id_us") Long id)
	{
		return iAccountService.getAccountByUser(id);
	}
}
