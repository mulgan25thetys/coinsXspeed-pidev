package horizure.micro.finance.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import horizure.micro.finance.entities.Claim;
import horizure.micro.finance.entities.Topic;
import horizure.micro.finance.repositories.ClaimRepository;
import horizure.micro.finance.services.ClaimService;


import horizure.micro.finance.services.IClaimService;

@CrossOrigin("*")
@RestController
@RequestMapping("claim")
public class ClaimController {
	
	 	@Autowired
	    IClaimService cs;
	    @Autowired
	    ClaimRepository repo;

	    @GetMapping("/retrieve-all-reclamations")
	    @ResponseBody
	    public List<Claim> getReclamations() {
	        return repo.findAll();
	    }

//	    @GetMapping("/retrieve-reclamation/{reclamation-id}")
//	    @ResponseBody
//	    public Complaint retrieveReclamation(@PathVariable("reclamation-id") Long id) {
//	        return cs.retrieveReclamation(id);
//	    }


	    @ResponseBody
	    @PostMapping("/add-claim")
	    public Claim add_complaint( @RequestBody Claim c){
	        return cs.add_Claim(c);
	    }



	    @DeleteMapping("/delete/{id}")
	    public void delete_complaint(@PathVariable("id") Long id_Complaint){
	        repo.deleteById(id_Complaint);
	    }

	    @GetMapping("/By/{topic}")
	    public List<Claim> FilterByTopic(@PathVariable("topic") Topic topic){
	    	System.out.println(cs.FilterByTopic(topic));
	        return cs.FilterByTopic(topic);
	    }

	    @GetMapping("/most_topic")
	    @ResponseBody
	    public Topic most_topic_complained(){
	        return cs.most_topic_complained();
	    }

	    @GetMapping("/triByUser")
	    @ResponseBody
	    public Map<Long, Long> triByUser(){
	        return cs.triByUser();
	    }
	    @GetMapping("/nbr/{id}")
	    @ResponseBody
	    public Long nbr_complaints_recieved_each_week(@PathVariable("id") Long id_user){
	      return   cs.nbr_Claim_recieved_each_week(id_user);
	    }


	    @ResponseBody
	    @GetMapping("/month")
	    public int Taux_complaints_each_month(){
	        return cs.Taux_Claim_each_month();
	    }

	    }


