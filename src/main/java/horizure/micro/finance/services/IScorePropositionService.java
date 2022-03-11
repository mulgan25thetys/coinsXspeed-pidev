package horizure.micro.finance.services;

import java.util.List;

import horizure.micro.finance.entities.ScoreProposition;


public interface IScorePropositionService {
	
	List<ScoreProposition> retrievePropositions(); //affichage
	
	ScoreProposition addScoreProp(ScoreProposition prop); //ajout
	
	ScoreProposition getScoreProp(Long id); // get un account
	
	void removeProposition(Long id); //suppression
}
