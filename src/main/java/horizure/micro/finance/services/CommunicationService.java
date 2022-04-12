package horizure.micro.finance.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import horizure.micro.finance.entities.Communication;
import horizure.micro.finance.entities.Message;
import horizure.micro.finance.entities.User;
import horizure.micro.finance.repositories.CommunicationRepository;
import horizure.micro.finance.repositories.MessageRepository;

@Service
public class CommunicationService implements ICommunicationService {
	
	@Autowired
	CommunicationRepository communicationRepository ;
	
	@Autowired
	MessageRepository messageRepository ;
	
	@Autowired
	private UserServiceImpl userService ;
	
	
	@Override
	public Communication findById(Long id) {
		Optional<Communication> result = communicationRepository.findById(id);
		Communication communication = null;
		
		if(result.isPresent()) {
			communication = result.get();
		}
		else {
			return communication;
		}
		return communication;
	}

	@Override
	public List<Communication> retrieveAllCommunication() {
		return (List<Communication>) communicationRepository.findAll();
	}

	@Override
	public void deleteCommunication(String id) {
		long id1 = Long.parseLong(id);
		communicationRepository.deleteById(id1);
		
	}

	@Override
	public Optional<Communication> retrieveCommunication(String id) {
		Optional<Communication> communication = communicationRepository.findById(Long.parseLong(id));
		return communication;
	}

	@Override
	public void store(Long userId, Message text) {
		Communication conv = null;
		  
		  User user = userService.findUserById(userId).orElse(null); 
		  Set<Message> messages = new HashSet<>();
		  Set<User> users = new HashSet<>();
		  users.add(user);
		 /* if(findById(conv_id) == null) {*/
		  conv = new Communication(users);
		  /*}else {
		  conv = findById(conv_id);
		  conv.setUsers(users);
		  //conv.setMessages(messages);
		  }*/
		  Communication savedconv = communicationRepository.save(conv);
		  Message mess = new Message(text.getText(), conv);
		  messageRepository.save(mess);
		
	}

}
