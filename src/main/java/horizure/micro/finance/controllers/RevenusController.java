package horizure.micro.finance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import horizure.micro.finance.entities.Revenus;
import horizure.micro.finance.services.IRevenusService;

@RestController
@RequestMapping("revenus")
public class RevenusController {

	@Autowired
	IRevenusService 	irevenusService;
	
	@GetMapping("get-revenus")
	public List<Revenus> getRevenus(){
		return irevenusService.getAll();
	}
}
