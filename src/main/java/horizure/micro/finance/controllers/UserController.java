package horizure.micro.finance.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import horizure.micro.finance.services.IUserService;
import java.util.List;

import horizure.micro.finance.entities.Egroup;
import horizure.micro.finance.entities.User;




@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	IUserService iUserService;
	@GetMapping("/list-users")
	@ResponseBody
	public List<User> getAllUsers(){
		return iUserService.retrieveUsers();
	}
	
	@PostMapping("/add-users")
	@ResponseBody
	public User addUser(@RequestBody User u) {
		return iUserService.addUser(u);
	}
	
	@PostMapping("/register-customer")
	@ResponseBody
	public User registerUser(@RequestBody User u) {
		return iUserService.registerUser(u);
	}
	
	@PutMapping("/edit-user/{id}")
	@ResponseBody
	public User editUser(@PathVariable("id") Long id,@RequestBody User u) {
		return iUserService.updateUser(u);
	}
	

	@GetMapping("/get-user/{id}")
	@ResponseBody
	public User getUser(@PathVariable("id") Long id){
		return iUserService.getUser(id);
	}
	
	
	@DeleteMapping("/delete-user/{id}")
	@ResponseBody
	public void deleteComment(@PathVariable("id") Long userId) {
		iUserService.removeUser(userId);
	}
	
	@GetMapping("/get-sumamountbyegroup/{egroup}")
	@ResponseBody
	public float getSumAmountByEGroup(Egroup egroup) {

		return iUserService.getSumAmountByEGroup(egroup);
	}
	
	
	}

