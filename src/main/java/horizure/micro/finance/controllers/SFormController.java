package horizure.micro.finance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import horizure.micro.finance.entities.ScoreForm;
import horizure.micro.finance.entities.ScoreResponse;
import horizure.micro.finance.services.IScoreFormService;

@RestController
@RequestMapping("scoreform")
public class SFormController {

	@Autowired
	IScoreFormService iscoreFormService;
	
	@PostMapping("/add-score-form")
	@ResponseBody
	public ScoreForm addForm(@RequestBody ScoreForm sf)
	{
		return iscoreFormService.addScoreForm(sf);
	}
	
	@GetMapping("/list-form")
	@ResponseBody
	public List<ScoreForm> getAllForms(){
		return iscoreFormService.retrieveForms();
	}
	
	@PutMapping("/answer-form/{iduser}")
	@ResponseBody
	public ScoreResponse CompleteForms(@RequestBody ScoreForm sf,@PathVariable("iduser") Long iduser){
		return iscoreFormService.completeScoreForm(iduser, sf) ;
	}
	
	@GetMapping("/get-responses-form")
	@ResponseBody
	public List<ScoreResponse> getResponseForms(){
		return iscoreFormService.getAllReponsesForm() ;
	}
	
	@GetMapping("/get-form/{idform}")
	@ResponseBody
	public ScoreForm getForm(@PathVariable("idform") Long idform){
		return iscoreFormService.retrieveScoreForm(idform);
	}
	
	@DeleteMapping("delete-form/{id}")
	@ResponseBody
	public ResponseEntity<String>  deleteForm(@PathVariable("id") Long id){
		//ResponseEntity<String> responses = ResponseEntity<String>();
		String message = iscoreFormService.deleteForm(id) == 1 ? "Form has been deleted successfully!" :"Form has not been deleted!";
		return new ResponseEntity<String> (message,HttpStatus.OK) ;
	}
	
	@DeleteMapping("delete-reponse/{id}")
	@ResponseBody
	public ResponseEntity<String>  deleteResponse(@PathVariable("id") Long id){
		//ResponseEntity<String> responses = ResponseEntity<String>();
		//String message = iscoreFormService.deleteResponse(id) == 1 ? "Form has been deleted successfully!" :"Form has not been deleted!";
		return new ResponseEntity<String> (message,HttpStatus.OK) ;
	}
	
	@PutMapping("/edit-form")
	@ResponseBody
	public ScoreForm editForm(@RequestBody ScoreForm sf)
	{
		return iscoreFormService.updateScoreForm(sf);
	}
	
	@GetMapping("/sort-form/")
	@ResponseBody
	public List<ScoreForm> sortForm(){
		return iscoreFormService.sortFormbyMostScoreAccount();
	}
	
	@GetMapping("/search-form/{value}")
	@ResponseBody
	public List<ScoreForm> searchForm(@PathVariable("value") String value){
		return iscoreFormService.searchAnyForm(value);
	}
	
	@GetMapping("/get-statistic")
	@ResponseBody
	public List<String> getStatisticForm(){
		return iscoreFormService.getStatistics();
	}
}
