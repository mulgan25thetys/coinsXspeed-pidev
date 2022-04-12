package horizure.micro.finance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import horizure.micro.finance.entities.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {

	@Query(value = "SELECT m FROM Message m WHERE m.communication.id = :id")
	 List<Message> findMessageByCommunicationId(@Param("id")Long id);
}
