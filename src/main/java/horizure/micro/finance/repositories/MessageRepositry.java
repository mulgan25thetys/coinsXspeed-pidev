package horizure.micro.finance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import horizure.micro.finance.entities.Message;
@Repository
public interface MessageRepositry extends JpaRepository<Message, Long> {
	@Query(value = "SELECT m FROM Message m WHERE m.communication.id:=id")
	 List<Message> findMessageByCommunicationId(@Param("id")Long id);


}
