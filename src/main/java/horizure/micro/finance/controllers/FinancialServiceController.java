package horizure.micro.finance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/list-financial-service")
	@ResponseBody
	public List<FinancialService> listFinService(){
		return ifinancialServiceService.listfinancialService();
	}
	
	@PostMapping("/add-financial-service/{iduser}")
	@ResponseBody
	public FinancialService addFinService(@PathVariable("iduser") Long id,@RequestBody FinancialService fs) {
		return ifinancialServiceService.addFinancialService(id, fs);
	}
}
