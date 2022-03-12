package horizure.micro.finance.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import horizure.micro.finance.entities.ScoreForm;

@Repository
public interface ScoreFormRepository extends CrudRepository<ScoreForm, Long>{

	@Modifying
	@Query(value = "UPDATE score_form f set f.last_updated_at  =:date WHERE f.id_score_from =:idform",nativeQuery = true)
	int updateForm(@Param("idform") Long idform,@Param("date") Date date);
	
}
