package horizure.micro.finance.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import horizure.micro.finance.entities.ScoreProposition;

@Repository
public interface ScorePropositionRepository extends CrudRepository<ScoreProposition, Long>{

}
