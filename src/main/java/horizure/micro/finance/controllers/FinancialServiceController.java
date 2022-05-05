package horizure.micro.finance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import horizure.micro.finance.entities.FinancialService;
import horizure.micro.finance.services.IFinancialServiceService;

@RestController
@RequestMapping("financial-service")
public class FinancialServiceController {
	
	@Autowired
	IFinancialServiceService ifinancialServiceService;
	
	@PostMapping("/add-financial-service")
	@ResponseBody
	public FinancialService addFinancialService(@RequestBody FinancialService FS) {
		return ifinancialServiceService.addFinancialService(FS);
	}
	
	
	@PutMapping("/add-financial-service-loan/{id_ServiceFinancial}/{idUser}")
	@ResponseBody
	public FinancialService addFinancialServiceLoan(@PathVariable("id_ServiceFinancial") long id_ServiceFinancial, @PathVariable("idUser") long id) {
		return ifinancialServiceService.addFinancialServiceLoan(id_ServiceFinancial,id);
	}
	
	
	@PostMapping("/add-financial-service-to-User/{iduser}")
	@ResponseBody
	public FinancialService addFinancialServiceToUserAccount(@PathVariable("iduser") Long id,@RequestBody FinancialService fs) {
		return ifinancialServiceService.addFinancialServiceToUserAccount(id, fs);
	}
	
	@GetMapping("/list-financial-service")
	@ResponseBody
	public List<FinancialService> retrieveAllFinancialService(){
		return ifinancialServiceService.retrieveAllFinancialService();
	}
	
	@GetMapping("/list-financial-service-account/{id_acc}")
	@ResponseBody
	public List<FinancialService> retrieveAllFinancialServiceAccount(@PathVariable("id_acc") Long id){
		return ifinancialServiceService.retrieveAllFinancialServiceAccount(id);
	}
	
	@GetMapping("/get-financial-service/{id_ServiceFinancial}")
	@ResponseBody
	public FinancialService retrieveFinancialService(@PathVariable("id_ServiceFinancial") Long id_ServiceFinancial){
		return ifinancialServiceService.retrieveFinancialService(id_ServiceFinancial);
	}
	
	@GetMapping("/get-account-financial-service/{id_account}")
	@ResponseBody
	public List<FinancialService> retrieveAccountFinancialService(@PathVariable("id_account") Long id_account){
		return ifinancialServiceService.retrieveAccountFinancialService(id_account);
	}
	
	@PutMapping("/Modify-FinancialService")
	@ResponseBody
	public FinancialService updateFinancialService(@RequestBody FinancialService FS) {
		return ifinancialServiceService.updateFinancialService(FS);
	}
	
}
