package horizure.micro.finance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import horizure.micro.finance.entities.User;
import horizure.micro.finance.services.IUserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	IUserService iUserService;
	
	@GetMapping("/list-user")
	@ResponseBody
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok().body(iUserService.findAllUsers());
	}

}
