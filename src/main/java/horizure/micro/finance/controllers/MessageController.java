package horizure.micro.finance.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import horizure.micro.finance.entities.Message;
import horizure.micro.finance.services.IMessageService;

@RestController
@RequestMapping("/Message")
public class MessageController {
	
	@Autowired
	IMessageService iMessageService ;
	
	@GetMapping("/retrieve-all-messages")
	@ResponseBody
	public List<Message> getMessages() {
	List<Message> list = iMessageService.retrieveAllMessages();
	return list;
	}
	
	@PostMapping("/add-message")
	@ResponseBody
	public Message addMessage(@RequestBody Message message1) {
	Message message = iMessageService.addMessage(message1);
	return message;
	}
	
	@GetMapping("/retrieve-message/{message-id}")
	@ResponseBody
	public Optional<Message> retrieveMessage(@PathVariable("message-id") String idMessage) {
	return iMessageService.retrieveMessage(idMessage);
	}
	
	@GetMapping("/messages/{convId}")
	@ResponseBody
	public List<Message> findMessageByCommunicationId (@PathVariable Long convId) {
	return iMessageService.findMessageByCommunicationId(convId);
	} 

}
