package horizure.micro.finance.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import horizure.micro.finance.entities.ScoreProposition;
import horizure.micro.finance.repositories.ScorePropositionRepository;

@Service
public class ScorePropositionServiceImpl implements IScorePropositionService{

	@Autowired
	ScorePropositionRepository scorePropositionRepository;
	
	@Override
	public List<ScoreProposition> retrievePropositions() {
		// TODO Auto-generated method stub
		return (List<ScoreProposition>)scorePropositionRepository.findAll();
	}

	@Override
	public ScoreProposition addScoreProp(ScoreProposition prop) {
		// TODO Auto-generated method stub
		prop.setCreated_at(new Date());
		return scorePropositionRepository.save(prop);
	}

	@Override
	public ScoreProposition getScoreProp(Long id) {
		// TODO Auto-generated method stub
		ScoreProposition scp = scorePropositionRepository.findById(id).orElse(null);
		return scp;
	}

	@Override
	public void removeProposition(Long id) {
		// TODO Auto-generated method stub
		scorePropositionRepository.deleteById(id);
	}

}
