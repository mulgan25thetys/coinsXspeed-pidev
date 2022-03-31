package horizure.micro.finance.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import horizure.micro.finance.entities.Message;
import horizure.micro.finance.repositories.MessageRepositry;

public class GestionMessageimpl implements IGestionMessage {
	@Autowired
	MessageRepositry messageRepositry;
	

	@Override
	public List<Message> retrieveAllMessages() {
		 List<Message>  list=messageRepositry.findAll();
		return list;
	}

	@Override
	public Message addMessage(Message message) {
		
		return messageRepositry.save(message);
	}

	@Override
	public Optional<Message> retrieveMessage(String idMessage) {
		Optional<Message> m=messageRepositry.findById(Long.parseLong(idMessage));
		return m;
	}

	@Override
	public List<Message> findMessageByCommunicationId(Long com_Id) {
		 List<Message> k=messageRepositry.findMessageByCommunicationId(com_Id);
		
		return k;
	}

}
