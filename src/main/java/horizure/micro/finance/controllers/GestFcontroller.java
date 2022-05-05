package horizure.micro.finance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import horizure.micro.finance.entities.Claim;
import horizure.micro.finance.entities.NoFinancialService;
import horizure.micro.finance.repositories.NoFinancialRepositry;
import horizure.micro.finance.services.NoFinancialservice;
@CrossOrigin("*")
@RestController
@RequestMapping("no-financial-service/")
public class GestFcontroller {
	@Autowired
	NoFinancialservice financialservice;
	@Autowired
	NoFinancialRepositry repo;
	 @GetMapping("list-all")
	    @ResponseBody
	    public List<NoFinancialService> getNoF() {
	        return repo.findAll();
	    }
	 @PostMapping("/add-fin")
	 @ResponseBody
	 public NoFinancialService addNoFinancialService(  @RequestBody NoFinancialService f ) {
		 //return financialservice.addNoFinancialService(f);
		 return repo.save(f);
		 
	 }
	 @GetMapping("/retrieve-financialserviceByUser/{user-id}")
	    @ResponseBody
	    public List<NoFinancialService>getByoFinancialServiceUserr(@PathVariable("user-id") Long userid){
		 return financialservice.getByoFinancialServiceUser(userid);
	  
	    }
	 @PutMapping("/update-fin")
	 @ResponseBody
	 public NoFinancialService updateNoFinancialService(  @RequestBody NoFinancialService f ) {
		 //return financialservice.addNoFinancialService(f);
		 return repo.save(f);
	 }
	

}
