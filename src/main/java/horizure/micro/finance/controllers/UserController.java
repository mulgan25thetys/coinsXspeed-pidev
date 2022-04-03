package horizure.micro.finance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@PostMapping("/add-user")
	@ResponseBody
	public ResponseEntity<User> addUser(@RequestBody User user){
		return ResponseEntity.ok().body(iUserService.saveUser(user));
	}
	
	@PutMapping("/edit-user/{id}")
	@ResponseBody
	public ResponseEntity<User> editUser(@RequestBody User user,@PathVariable("id") Long id){
		return ResponseEntity.ok().body(iUserService.updateUser(id,user));
	}
	
	@DeleteMapping("delete-user/{id}")
	@ResponseBody
	public ResponseEntity<User> deleteUser(@PathVariable("id") Long id){
		return ResponseEntity.ok().body(iUserService.deleteUser(id));
	}
	
}
