package horizure.micro.finance.services;

import java.util.List;
import java.util.Optional;

import horizure.micro.finance.entities.Communication;
import horizure.micro.finance.entities.Message;

public interface ICommunicationService {
	
	Communication findById(Long id);
	
	List<Communication> retrieveAllCommunication();
	
	void deleteCommunication(String id);
	
	Optional<Communication> retrieveCommunication(String id);
	
	 public void store(Long userId,/* Long conv_id,*/ Message text);

}
