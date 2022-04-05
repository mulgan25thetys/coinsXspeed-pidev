package horizure.micro.finance.controllers;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import horizure.micro.finance.services.IUserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	IUserService iUserService;
	


}