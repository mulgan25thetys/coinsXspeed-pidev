package horizure.micro.finance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import horizure.micro.finance.entities.Payement;
import horizure.micro.finance.services.IPayementService;

@RestController
@RequestMapping("/Payement")
public class PayementController {
	@Autowired
	IPayementService iPayementService;
	
	@GetMapping("/getpayementmensuality/{idfinancial}")
	@ResponseBody
	public List<Payement> getPayement_mensuality(@PathVariable("idfinancial") Long id_ServiceFinancial){
		System.out.println(id_ServiceFinancial);
		return iPayementService.getPayement_mensuality(id_ServiceFinancial);
	}
	
	@GetMapping("/getpayementBlock/{idfinancial}")
	@ResponseBody
	public List<Payement> getPayement_Block(@PathVariable("idfinancial") Long id_ServiceFinancial){
		System.out.println(id_ServiceFinancial);
		return iPayementService.getPayement_Block(id_ServiceFinancial);
	}
	
	@PostMapping("/addPayement/{idfinancial}")
	@ResponseBody
	public List<Payement> addPayement(@PathVariable("idfinancial") Long id_ServiceFinancial){
		System.out.println(id_ServiceFinancial);
		return iPayementService.addPayement(id_ServiceFinancial);
	}

}
