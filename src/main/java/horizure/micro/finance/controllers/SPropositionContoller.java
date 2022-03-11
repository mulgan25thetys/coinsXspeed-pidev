package horizure.micro.finance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import horizure.micro.finance.entities.ScoreProposition;
import horizure.micro.finance.services.IScorePropositionService;

@RestController
@RequestMapping("proposition")
public class SPropositionContoller {

	@Autowired
	IScorePropositionService iscorePropositionService;
	
	@GetMapping("/list-propositions")
	@ResponseBody
	public List<ScoreProposition> getAllPropositions(){
		return iscorePropositionService.retrievePropositions();
	}
	
	@PostMapping("/add-proposition")
	@ResponseBody
	public ScoreProposition addProposition(@RequestBody ScoreProposition scp) {
		return iscorePropositionService.addScoreProp(scp);
	}
	
	@GetMapping("/get-proposition/{idprop}")
	@ResponseBody
	public ScoreProposition getProposition(@PathVariable("idprop") Long idprop){
		return iscorePropositionService.getScoreProp(idprop);
	}
	
	@DeleteMapping("/delete-proposition/{idprop}")
	@ResponseBody
	public void deleteProposition(@PathVariable("idprop") Long idprop) {
		iscorePropositionService.removeProposition(idprop);
	}
}
