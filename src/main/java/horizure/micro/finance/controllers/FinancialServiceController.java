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
	public FinancialService addFinancialServic(@RequestBody FinancialService FS) {
		return ifinancialServiceService.addFinancialService(FS);
	}
	
	
	@PostMapping("/add-financial-service-loan/{idUser}")
	@ResponseBody
	public FinancialService addFinancialServiceLoan(@RequestBody FinancialService FS, @PathVariable("idUser") long id) {
		return ifinancialServiceService.addFinancialServiceLoan(FS,id);
	}
	
	
	@PostMapping("/add-financial-service-to-account/{iduser}")
	@ResponseBody
	public FinancialService addFinancialServiceToUserAccount(@PathVariable("iduser") Long id,@RequestBody FinancialService fs) {
		return ifinancialServiceService.addFinancialServiceToUserAccount(id, fs);
	}
	
	@GetMapping("/List-FinancialService")
	@ResponseBody
	public List<FinancialService> retrieveAllFinancialService(){
		return ifinancialServiceService.retrieveAllFinancialService();
	}
	
	@GetMapping("/Get-FinancialService/{id_ServiceFinancial}")
	@ResponseBody
	public FinancialService retrieveFinancialService(@PathVariable("id_ServiceFinancial") Long id_ServiceFinancial){
		return ifinancialServiceService.retrieveFinancialService(id_ServiceFinancial);
	}
	
	@PutMapping("/Modify-FinancialService")
	@ResponseBody
	public FinancialService updateFinancialService(@RequestBody FinancialService FS) {
		return ifinancialServiceService.updateFinancialService(FS);
	}
}
