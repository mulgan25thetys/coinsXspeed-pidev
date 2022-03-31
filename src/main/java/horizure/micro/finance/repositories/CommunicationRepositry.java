package horizure.micro.finance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import horizure.micro.finance.entities.Communication;

public interface CommunicationRepositry extends JpaRepository<Communication, Long> {

}
