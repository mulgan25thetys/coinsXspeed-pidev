package horizure.micro.finance.repositories;

import java.util.Date;
import java.util.List;

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
	
	@Query(value = "SELECT * FROM score_form FULL JOIN user ON id_score_from = user.scoreform_id_score_from GROUP BY user.user_id ORDER BY last_updated_at DESC",nativeQuery = true)
	List<ScoreForm> sortFormByUpdated();
	
	@Query(value = ("SELECT * FROM score_form f INNER JOIN score_question q ON f.id_score_from = q.question_form_id_score_from WHERE f.created_at LIKE %:value% OR f.description LIKE %:value% OR last_updated_at LIKE %:value% OR f.title LIKE %:value% OR q.created_at LIKE %:value% OR q.description LIKE %:value% OR q.points LIKE %:value% OR q.title LIKE %:value% OR q.answer_id_proposition LIKE %:value% ORDER BY f.last_updated_at DESC"),nativeQuery = true)
	List<ScoreForm> searchForm(@Param("value") String value);
}
