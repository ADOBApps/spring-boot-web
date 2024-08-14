package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.User;

@Controller
@RequestMapping("/app")
public class IndexController {

	@GetMapping({"/index", "/", "", "/home"})
	public String index(Model model) {
		model.addAttribute("title", "Hi Spring Framework");
		return "index";
	}
	
	@GetMapping({"/profile", "/profile/"})
	public String profile(Model model) {
		User user = new User();
		user.setName("Andres");
		user.setLastname("Fernandez");
		user.setEmail("andres.fernandez@gmail.com");
		
		model.addAttribute("user", user);
		model.addAttribute("title", "User profile");
		model.addAttribute("titulo", "User profile: ".concat(user.getName()));
		model.addAttribute("email", user.getEmail());
		return "profile";
	}
	
	@GetMapping({"/tolist", "/tolist/"})
	public String tolist(Model model) {
		/*
		List<User> users = new ArrayList<>();
		users.add(new User("Andres", "Fernandez", "andres.fernandez@gmail.com"));
		users.add(new User("David", "Paz", "david.paz@gmail.com"));
		users.add(new User("Juan", "Arango", "juan.arango@gmail.com"));
		model.addAttribute("users", users);
		*/
		model.addAttribute("title","User list");		
		return "tolist";
	}
	
	@ModelAttribute("users")
	public List<User> fillUsers(){
		List<User> users = new ArrayList<>();
		users.add(new User("Andres", "Fernandez", "andres.fernandez@gmail.com"));
		users.add(new User("David", "Paz", "david.paz@gmail.com"));
		users.add(new User("Juan", "Arango", "juan.arango@gmail.com"));
		return users;
	}

	
}
