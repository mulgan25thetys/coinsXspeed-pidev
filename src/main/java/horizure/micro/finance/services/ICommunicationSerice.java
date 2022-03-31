package horizure.micro.finance.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import horizure.micro.finance.entities.Communication;
import horizure.micro.finance.entities.Message;

public interface ICommunicationSerice  {
	Communication findById (Long id);
	List<Communication> retrieveAllCommunication();
	void deleteCommunication(String id);
	Optional<Communication> retrieveCommunication(String id);
	void store(Long userId,/* Long conv_id,*/ Message text) throws IOException ;


}
