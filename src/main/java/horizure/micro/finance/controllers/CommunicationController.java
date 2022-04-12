package horizure.micro.finance.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import horizure.micro.finance.entities.Communication;
import horizure.micro.finance.services.CommunicationService;
import horizure.micro.finance.services.ICommunicationService;
@RestController
@RequestMapping("/Communication")
public class CommunicationController {
	
	@Autowired
	ICommunicationService iCommunicationService;
	@Autowired
	CommunicationService communicationService;
	
	@GetMapping("/Retreive-Communication/{communication-id}")
	@ResponseBody
	public Optional<Communication> retrieveCommunication(@PathVariable("communication-id") String id) {
	return iCommunicationService.retrieveCommunication(id);
	}
	
	@GetMapping("/Retreive-All-Communication")
	@ResponseBody
	public List<Communication> getCommunication() {
	List<Communication> list = iCommunicationService.retrieveAllCommunication();
	return list;
	}
	
	@DeleteMapping("/Delete-Communication/{communication-id}")
	@ResponseBody
	public void removeConversation(@PathVariable("communication-id") String id) {
		iCommunicationService.deleteCommunication(id);
	}
	
	
	/*@PostMapping(value = "/Communication-upload/{userId}/{message}") 
	  public ResponseEntity uploadMessage(@RequestParam("userId") Long userId, @RequestParam("message") String text) {
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
	*/
	
	

}
