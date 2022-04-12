package horizure.micro.finance.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import horizure.micro.finance.entities.Message;
import horizure.micro.finance.repositories.MessageRepository;

@Service
public class MessageService implements IMessageService {
	
	@Autowired
	MessageRepository messageRepository ;
	

	@Override
	public List<Message> retrieveAllMessages() {
		
		return (List<Message>) messageRepository.findAll();
	}

	@Override
	public Message addMessage(Message message) {
		
		return messageRepository.save(message);
	}

	@Override
	public Optional<Message> retrieveMessage(String idMessage) {
		Optional<Message> message = messageRepository.findById(Long.parseLong(idMessage));
			return message;
	}


	@Override
	public List<Message> findMessageByCommunicationId(Long convId) {
		return messageRepository.findMessageByCommunicationId(convId);
	}
	

}
