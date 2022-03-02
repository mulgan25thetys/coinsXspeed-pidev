package horizure.micro.finance.services;

import java.util.List;

import horizure.micro.finance.entities.ScoreQuestion;

public interface IScoreQuestionService {

	List<ScoreQuestion> retrieveQuestions(); //affichage
	
	ScoreQuestion addScoreQuestion(ScoreQuestion question); //ajout
	
	ScoreQuestion updateScoreQuestion(ScoreQuestion question); // modification
	
	ScoreQuestion retrieveScoreQuestion(Long id); // get un account
	
	void removeQuestion(Long id); //suppression
}
