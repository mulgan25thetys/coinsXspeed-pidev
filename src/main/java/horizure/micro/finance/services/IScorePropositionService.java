package horizure.micro.finance.services;

import java.util.List;

import horizure.micro.finance.entities.ScoreProposition;


public interface IScorePropositionService {
	
	List<ScoreProposition> retrieveAccounts(); //affichage
	
	ScoreProposition addScoreProp(ScoreProposition prop); //ajout
	
	ScoreProposition updateScoreProp(ScoreProposition prop); // modification
	
	ScoreProposition retrieveScoreProp(Long id); // get un account
	
	void removeProposition(Long id); //suppression
}
