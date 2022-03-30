package horizure.micro.finance.controllers;
import java.util.List;

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
import horizure.micro.finance.entities.User;
import horizure.micro.finance.services.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	IUserService userService;

	
	
	@GetMapping("/retrieve-users")
	@ResponseBody

	public List<User> getUsers() {
		List<User> listUsers = userService.retrieveAllUsers();
		return listUsers;
		
	}
	
	@GetMapping("/retrieve-user/{user-id}")
	@ResponseBody
	public User retrieveUser(@PathVariable("user-id") Long userId) {
	return userService.retrieveUser(userId);
	
	}
		@PostMapping("/add-user")
	@ResponseBody
	public User addUser(@RequestBody User u)
	{
	User user = userService.addUser(u);
	return user;
	}
	
	@DeleteMapping("/remove-user/{user-id}")
	@ResponseBody
	public void removeUser(@PathVariable("user-id") Long userId) {
	userService.removeUser(userId);
	
	}
	
	@PutMapping("/modify-user")
	@ResponseBody
	public User modifyUser(@RequestBody User user) {
	return userService.updateUser(user);
	}	
}


