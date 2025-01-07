package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.User;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${text.indexcontroller.index.title}")
	private String textIndex;
	
	@Value("${text.indexcontroller.profile.title}")
	private String profileIndex;
	
	@Value("${text.indexcontroller.list.title}")
	private String listIndex;

	@GetMapping({"/index", "/", "", "/home"})
	public String index(Model model) {
		model.addAttribute("title", textIndex);
		return "index";
	}
	
	@GetMapping({"/profile", "/profile/"})
	public String profile(Model model) {
		User user = new User();
		user.setName("Andres");
		user.setLastname("Fernandez");
		user.setEmail("andres.fernandez@gmail.com");
		
		model.addAttribute("user", user);
		model.addAttribute("title", profileIndex);
		model.addAttribute("titulo", profileIndex.concat(user.getName()));
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
		model.addAttribute("title",profileIndex);		
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
