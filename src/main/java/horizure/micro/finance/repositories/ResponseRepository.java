package horizure.micro.finance.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import horizure.micro.finance.entities.ScoreResponse;

public interface ResponseRepository extends CrudRepository<ScoreResponse, Long>{

	@Modifying
	@Query(value = "DELETE FROM score_response WHERE form_id_score_from =:id_form",nativeQuery = true)
	void DeleteAllResponse(@Param("id_form") Long id);
	
	@Query(value = "SELECT *FROM score_response WHERE form_id_score_from =:id_form",nativeQuery = true)
	List<ScoreResponse> getResponses(@Param("id_form") Long id);
}
