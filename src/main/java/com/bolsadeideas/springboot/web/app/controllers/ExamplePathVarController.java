package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vars")
public class ExamplePathVarController {
	
	@GetMapping({"/home", "/"})
	public String index(Model model) {
		model.addAttribute("title", "Index PathVar");
		return "vars/index";
	}
	
	@GetMapping({"/test"})
	public String test(Model model) {
		model.addAttribute("title", "Index PathVar");
		return "vars/test";
	}
	
	@GetMapping("/string/{text}")
	public String Vars(@PathVariable String text, Model model) {
		model.addAttribute("title", "Get parameter from Path(@PathVariable)");
		model.addAttribute("result", "Text sent is: " + text);
		return "vars/view";
	}

	@GetMapping("/string/{text}/{number}")
	public String Vars(@PathVariable String text, @PathVariable Integer number, Model model) {
		model.addAttribute("title", "Get parameter from Path(@PathVariable)");
		model.addAttribute("result", "Text sent is: " + text
				+ "the number sent in the path was: " + number);
		return "vars/view";
	}
}
