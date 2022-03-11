package horizure.micro.finance.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import horizure.micro.finance.entities.ScoreProposition;
import horizure.micro.finance.entities.ScoreQuestion;
import horizure.micro.finance.repositories.ScorePropositionRepository;
import horizure.micro.finance.repositories.ScoreQuestionRepository;

@Service
public class ScoreQuestionServiceImpl implements IScoreQuestionService{

	@Autowired
	ScoreQuestionRepository scoreQuestionRepository;
	
	@Autowired
	ScorePropositionRepository scorePropositionRepository;

	@Override
	public List<ScoreQuestion> retrieveQuestions() {
		// TODO Auto-generated method stub
		return (List<ScoreQuestion>)scoreQuestionRepository.findAll();
	}

	@Transactional
	public ScoreQuestion addScoreQuestion(ScoreQuestion question) {
		// TODO Auto-generated method stub
		List<ScoreProposition> listPropositions = question.getPropositions();//list des propositions
		
		for(int i = 0;i<listPropositions.size();i++) { //lister les propositions
			listPropositions.get(i).setCreated_at(new Date());
			
			//listPropositions.get(i).getQuestions().add(question);//ajout de la question à des propositions
			
			if(question.getAnswer().getDescription() == listPropositions.get(i).getDescription()) {
				question.setAnswer(listPropositions.get(i)); //choisir la proposition qui correspondant à la réponse
			}
			
			scorePropositionRepository.save(listPropositions.get(i)); //enregistrer une à une les propositions
		}
		
		question.setPropositions(listPropositions);
		question.setCreated_at(new Date()); //insertion de la date actuelle
		
		scoreQuestionRepository.save(question);//enregistrement de la question
		return question;
	}

	@Override
	public ScoreQuestion updateScoreQuestion(ScoreQuestion question) {
		// TODO Auto-generated method stub
		return scoreQuestionRepository.save(question);
	}

	@Override
	public ScoreQuestion retrieveScoreQuestion(Long id) {
		// TODO Auto-generated method stub
		return scoreQuestionRepository.findById(id).orElse(null);
	}

	@Override
	public void removeQuestion(Long id) {
		// TODO Auto-generated method stub
		scoreQuestionRepository.deleteById(id);
	}
	
	
}
