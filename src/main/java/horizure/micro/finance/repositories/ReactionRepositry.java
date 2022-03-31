package horizure.micro.finance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import horizure.micro.finance.entities.Reaction;

public interface ReactionRepositry  extends JpaRepository<Reaction, Long>{

}
