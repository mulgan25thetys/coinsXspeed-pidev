package horizure.micro.finance.repositories;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import horizure.micro.finance.entities.ScoreResponse;

public interface ResponseRepository extends CrudRepository<ScoreResponse, Long>{

	@Modifying
	@Query(value = "DELETE FROM score_response WHERE form_id_score_from =:id_form",nativeQuery = true)
	void DeleteAllResponse(@Param("id_form") Long id);
}
