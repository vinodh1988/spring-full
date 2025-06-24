package com.solution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.solution.services.DataService;

@Controller
@RequestMapping("/firstmvc")
public class FirstMVCController {

	@Autowired
	private DataService dataservice;
	
@RequestMapping("/welcome")
  public String welcome(ModelMap map) {
	// This method will return the name of the view to be rendered
	// In this case, it will return "welcome" which corresponds to a view named "welcome.jsp"
	  map.addAttribute("message", "Welcome to the First MVC Controller!");
	  map.addAttribute("names",dataservice.getNames());
	  return "home";
  }
}
