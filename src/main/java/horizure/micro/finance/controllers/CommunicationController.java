package horizure.micro.finance.controllers;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import horizure.micro.finance.entities.Claim;
import horizure.micro.finance.entities.Communication;
import horizure.micro.finance.entities.Message;
import horizure.micro.finance.repositories.ClaimRepository;
import horizure.micro.finance.repositories.CommunicationRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import horizure.micro.finance.services.CommunicationService;
import horizure.micro.finance.services.ICommunicationService;
@CrossOrigin("*")
@RestController
@RequestMapping("communication")
public class CommunicationController {
	
    @Autowired
    CommunicationRepository repo;
	
	@Autowired
	ICommunicationService iCommunicationService;
	@Autowired
	CommunicationService communicationService;
	
	@GetMapping("/retreive-communication/{communication-id}")
	@ResponseBody
	public Optional<Communication> retrieveCommunication(@PathVariable("communication-id") String id) {
	return iCommunicationService.retrieveCommunication(id);
	}
	
	@GetMapping("/retreive-all-communication")
	@ResponseBody
	public List<Communication> getCommunication() {
	List<Communication> list = iCommunicationService.retrieveAllCommunication();
	return list;
	}
	
	@DeleteMapping("/delete-communication/{communication-id}")
	@ResponseBody
	public void removeConversation(@PathVariable("communication-id") String id) {
		iCommunicationService.deleteCommunication(id);
	}
	
	
    @ResponseBody
    @PostMapping("/add-communication")
    public Communication add_Communication( @RequestBody Communication c){
        return repo.save(c);
    }
	
	
	
	

	@PostMapping(value = "/communication-upload/{userId}/{message}") 
	  public ResponseEntity uploadMessage(@PathVariable("userId") Long userId, @PathVariable("message") String text) {

		  String messageResponse = ""; 
		  Message message = new Message();
		  try { 
			  
			  message = new ObjectMapper().readValue(text, Message.class);
			  
			  communicationService.store(userId, message);

			  messageResponse = "Uploaded successfully: ";
	  
		  	return ResponseEntity.status(HttpStatus.OK).body(messageResponse);
	  
	  } catch (Exception e) { e.printStackTrace(); 
	  			messageResponse = "Could not upload the conversation!"; 
	  			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(messageResponse); } }

}
