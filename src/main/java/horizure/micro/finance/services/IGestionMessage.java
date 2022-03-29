package horizure.micro.finance.services;

import java.util.List;
import java.util.Optional;

import horizure.micro.finance.entities.Message;

public interface IGestionMessage {
	List<Message> retrieveAllMessages();
	Message addMessage(Message message);
	Optional<Message> retrieveMessage(String idMessage);
	List<Message> findMessageByCommunicationId(Long com_id);


}
