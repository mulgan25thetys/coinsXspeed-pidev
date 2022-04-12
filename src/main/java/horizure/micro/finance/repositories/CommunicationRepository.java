package horizure.micro.finance.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import horizure.micro.finance.entities.Communication;

@Repository
public interface CommunicationRepository extends CrudRepository<Communication, Long> {

}
