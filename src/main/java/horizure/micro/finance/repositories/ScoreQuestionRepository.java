package horizure.micro.finance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import horizure.micro.finance.entities.ScoreQuestion;

@Repository
public interface ScoreQuestionRepository extends CrudRepository<ScoreQuestion, Long>{
	
	@Query(value = "SELECT id_score_question,q.title,q.description,answer_id_proposition ,points,q.created_at,question_form_id_score_from FROM score_question q INNER JOIN score_form f ON q.question_form_id_score_from = f.id_score_from WHERE f.id_score_from =:idform",nativeQuery = true)
	List<ScoreQuestion> getAllQuestionOfThisForm(@Param("idform") Long idform);
	
	@Query(value ="SELECT CASE WHEN SUM(points) IS NULL THEN 0 ELSE SUM(points) END scorePoints FROM score_question q INNER JOIN score_form f ON q.question_form_id_score_from = f.id_score_from WHERE f.id_score_from =:idform",nativeQuery = true)
	int getTotalScore(@Param("idform") Long idform);
}
