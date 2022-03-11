package horizure.micro.finance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import horizure.micro.finance.entities.ScoreForm;
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
	public ResponseEntity<String>  CompleteForms(@RequestBody ScoreForm sf,@PathVariable("iduser") Long iduser){
		return new ResponseEntity<String> (iscoreFormService.completeScoreForm(iduser, sf),HttpStatus.INTERNAL_SERVER_ERROR) ;
	}
	
}
