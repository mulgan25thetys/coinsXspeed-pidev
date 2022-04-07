package horizure.micro.finance.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import horizure.micro.finance.entities.ScoreForm;
import horizure.micro.finance.entities.ScoreProposition;
import horizure.micro.finance.entities.ScoreQuestion;
import horizure.micro.finance.entities.User;
import horizure.micro.finance.repositories.AccountRepository;
import horizure.micro.finance.repositories.ScoreFormRepository;
import horizure.micro.finance.repositories.ScorePropositionRepository;
import horizure.micro.finance.repositories.ScoreQuestionRepository;
import horizure.micro.finance.repositories.UserRepository;

@Service
public class ScoreFormServiceImpl implements IScoreFormService{

	@Autowired
	ScoreFormRepository scoreFormRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	ScoreQuestionRepository scoreQuestionRepository;
	
	@Autowired
	ScorePropositionRepository scorePropositionRepository;
	
	@Override
	public List<ScoreForm> retrieveForms() {
		// TODO Auto-generated method stub
		return (List<ScoreForm>)scoreFormRepository.findAllDESC();
	}

	@Transactional
	public ScoreForm addScoreForm(ScoreForm form) {
		// TODO Auto-generated method stub
		for (ScoreQuestion question : form.getQuestions()) { //lister les questions
			question.setCreated_at(new Date());
			question.setQuestionForm(form); //ajouter le formulaire score a la question
			
			if(question.getPropositions().size() > 0) {
				for(ScoreProposition proposition :question.getPropositions()) { //lister les propostions pour une question donnée
					proposition.setCreated_at(new Date()); 
					  //proposition.getQuestions().add(question); //ajouter la question au proposition
					
					if(question.getAnswer().equals(proposition)) { //recherche de réponse 
						question.setAnswer(proposition); //ajouter la réponse de la question
					}
				}
			}
		}
		form.setCreated_at(new Date()); //enregistrer la date actuelle
		scoreFormRepository.save(form); // enregistrement du formulaire
		return form;
	}

	@Override
	public ScoreForm updateScoreForm(ScoreForm form) {
		// TODO Auto-generated method stub
		for (ScoreQuestion question : form.getQuestions()) { //lister les questions
			question.setCreated_at(new Date());
			question.setQuestionForm(form); //ajouter le formulaire score a la question
			
			if(question.getPropositions().size() > 0) {
				for(ScoreProposition proposition :question.getPropositions()) { //lister les propostions pour une question donnée
					proposition.setCreated_at(new Date()); 
					  //proposition.getQuestions().add(question); //ajouter la question au proposition
					
					if(question.getAnswer().equals(proposition)) { //recherche de réponse 
						question.setAnswer(proposition); //ajouter la réponse de la question
					}
				}
			}
		}
		form.setLastUpdated_at(new Date()); //enregistrer la date actuelle
		scoreFormRepository.save(form); // enregistrement du formulaire
		return form;
	}

	@Override
	public ScoreForm retrieveScoreForm(Long id) {
		// TODO Auto-generated method stub
		ScoreForm sf = scoreFormRepository.findById(id).orElse(null);
		return sf;
	}

	@Transactional
	public String completeScoreForm(Long idUser ,ScoreForm forms) {
		String result ="";
		User user = userRepository.findById(idUser).orElse(null);//recupere le user
		boolean verifForm = scoreFormRepository.existsById(forms.getId_scoreForm());//verifier si le formulaire existe
		int score = 0;
		int totalPoints = 0;
		
		if(user != null && user.getAccount() != null && verifForm) { //rassurer que le user existe et que le questionnaire n'est pas vide
			List<ScoreQuestion> questions = forms.getQuestions(); //recuperer les questions envoyés par user
			List<ScoreQuestion> baseQuestions = scoreQuestionRepository.getAllQuestionOfThisForm(forms.getId_scoreForm());//recuperer les question de la base de donnée
			
			totalPoints = scoreQuestionRepository.getTotalScore(forms.getId_scoreForm());
			if(totalPoints !=0) {
					for(int i=0;i<questions.size();i++) { //parcourir les questions répondus par l'utilisateur
					
						if(questions.get(i).equals(baseQuestions.get(i))) {
							if(questions.get(i).getAnswer().equals(baseQuestions.get(i).getAnswer())) {//comparer les réponses des questions
								score += baseQuestions.get(i).getPoints(); //affecter le score
							}else {
								result = "Veuillez vérifier les réponses!";
							}
						}else { result = "Veuillez bien répondre aux questions! ou ces questions sont inexistantes!"; }
				}
			}else { result = "Ce formulaire est vide!"; }
		}else { result = "Ce formulaire est inexistant! ou bien vous devez avoir un compte pour pousuivre cette opération!"; }
		
		if(score !=0) {
			result = "Vous avez obtenu : "+score+"/"+totalPoints;
		    user.setScoreform(forms);//affecter le formulaire à user
		    scoreFormRepository.updateForm(forms.getId_scoreForm(), new Date());//mettre à jour le formulaire
		    Boolean isApproved = (float)((float)score / (float)totalPoints) >= 0.65 ? true :false;//approuver le compte
			accountRepository.assynScoreToAccount(user.getAccount().getId_account(), score,isApproved);//affecter le score au compte de user
		}
		return result; //retourner le score
	}

	@Transactional
	public int deleteForm(Long idForm) {
		// TODO Auto-generated method stub
		int result=0;
		ScoreForm form = scoreFormRepository.findById(idForm).orElse(null);
		if(form != null) {
			for(User user :form.getUsers()) { //retirer le formulaire des users
				user.setScoreform(null); 
				user.getAccount().setScore(0);
			} 
			scoreFormRepository.delete(form);
			result = 1;
		}else {
			result = -1;
		}
		return result;
	}

	@Override
	public List<ScoreForm> sortFormbyMostScoreAccount() {
		// TODO Auto-generated method stub
		return (List<ScoreForm>)scoreFormRepository.sortFormByUpdated();
	}

	@Override
	public List<ScoreForm> searchAnyForm(String searchValue) {
		// TODO Auto-generated method stub
		return (List<ScoreForm>)scoreFormRepository.searchForm(searchValue);
	}

	@Override
	public List<String> getStatistics() {
		// TODO Auto-generated method stub
		List<String> messageStatistic = new ArrayList<>();
		String message="";
		List<ScoreForm> allForms = (List<ScoreForm>)scoreFormRepository.findAll();
		
		int nbrUsers =0;
		int nbrQuestions=0;
		
		for (ScoreForm scoreForm : allForms) {
			//calculer le nombre des users associés
			nbrUsers = scoreForm.getUsers().size();
			//calculer le nombre des questions
			nbrQuestions = scoreForm.getQuestions().size();
			int nbrpropositions=0;
			for (ScoreQuestion question : scoreForm.getQuestions()) { //parcourir les questions
				nbrpropositions +=question.getPropositions().size();
			}
			message = "Form "+scoreForm.getTitle()+" Question(s) ("+nbrQuestions+") "
					+ "Propositions ("+nbrpropositions+")  "
					+ "Users ("+nbrUsers+") in that form";
			messageStatistic.add(message);
		}
		return messageStatistic;
	}

}
