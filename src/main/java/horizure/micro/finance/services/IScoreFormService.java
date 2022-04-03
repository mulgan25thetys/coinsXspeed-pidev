package horizure.micro.finance.services;

import java.util.List;

import horizure.micro.finance.entities.ScoreForm;

public interface IScoreFormService {
	
	List<ScoreForm> retrieveForms(); //affichage
	
	ScoreForm addScoreForm(ScoreForm form); //ajout
	
	ScoreForm updateScoreForm(ScoreForm form); // modification
	
	ScoreForm retrieveScoreForm(Long id); // get un account
	
	String completeScoreForm(Long idUser,ScoreForm forms); //repondre au questionnement
	
	int deleteForm(Long idForm);
	
	List<ScoreForm> sortFormbyMostScoreAccount(); //trier les formulaire selon les plus grands score obtenus par les users
	
	List<ScoreForm> searchAnyForm(String searchValue); //rechercher un formulaire pour n'importe quelle valueur du champs
	
}
