package horizure.micro.finance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import horizure.micro.finance.entities.Reaction;

@Repository
public interface ReactionRepositry  extends JpaRepository<Reaction, Long>{

}
