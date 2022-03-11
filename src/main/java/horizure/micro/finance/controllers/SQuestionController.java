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

import horizure.micro.finance.entities.ScoreQuestion;
import horizure.micro.finance.services.IScoreQuestionService;

@RestController
@RequestMapping("questions")
public class SQuestionController {


	@Autowired
	IScoreQuestionService iscoreQuestionService;
	
	@GetMapping("/list-questions")
	@ResponseBody
	public List<ScoreQuestion> getAllPropositions(){
		return iscoreQuestionService.retrieveQuestions();
	}
	
	@PostMapping("/add-question")
	@ResponseBody
	public ScoreQuestion addQuestion(@RequestBody ScoreQuestion scq) {
		return iscoreQuestionService.addScoreQuestion(scq);
	}
	
	@GetMapping("/get-question/{idq}")
	@ResponseBody
	public ScoreQuestion getProposition(@PathVariable("idq") Long idq){
		return iscoreQuestionService.retrieveScoreQuestion(idq);
	}
	
	@DeleteMapping("/delete-question/{idq}")
	@ResponseBody
	public void deleteProposition(@PathVariable("idq") Long idq) {
		iscoreQuestionService.removeQuestion(idq);
	}
}
