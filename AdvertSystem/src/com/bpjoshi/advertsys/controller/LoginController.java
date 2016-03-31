package com.bpjoshi.advertsys.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bpjoshi.advertsys.model.User;
import com.bpjoshi.advertsys.service.UserService;

/**
 * @author Bhagwati Prasad - write2bpj@gmail.com
 *  */

@Controller
public class LoginController {
	
	private UserService userService;
	private static Logger logger= Logger.getLogger(LoginController.class);
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/")
	public String showHome(){
		logger.info("Showing Home Page...");
		return "home";
	}
	
	@RequestMapping("/admin")
	public String showAdmin(Model model){
		List<User> userList= userService.getAllUsers();
		model.addAttribute("userList", userList);
		return "admin";
	}
	
	@RequestMapping("/accessDenied")
	public String showAccessDenied(){
		return "accessDenied";
	}
	
	@RequestMapping("/login")
	public String showLogin(){
		
		return "login";
	}
	
	@RequestMapping("/logout")
	public String showLogout(){
		
		return "logout";
	}
	
	@RequestMapping("/createAccount")
	public String createAccount(Model model){
		model.addAttribute("user", new User());
		return "createAccount";
	}
	
	@RequestMapping(value="/doCreateAccount", method=RequestMethod.POST)
	public String doCreateAccount(Model model, @Valid User user, BindingResult result){
		if(result.hasErrors()){
			return "createAccount";
		}
		user.setEnabled(true);
		user.setAuthority("ROLE_USER");
		
		if(userService.exists(user.getUsername())){
			
		}
		
		try {
			userService.createAccount(user);
		} catch (DuplicateKeyException e) {
			result.rejectValue("username", "DuplicateKey.user.username");
			return "createAccount";
		}
		return "createdAccount";
	}
}
