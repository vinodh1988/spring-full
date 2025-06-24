package com.solution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.solution.services.DataService;
import com.solution.utilities.ApplicatonCounter;
import com.solution.utilities.SessionCounter;

@Controller
@RequestMapping("/firstmvc")
public class FirstMVCController {

	@Autowired
	private DataService dataservice;
	
	@Autowired
	private ApplicatonCounter applicationCounter;
	
	@Autowired
	private SessionCounter sessionCounter;

  // This method handles requests to the "/welcome" URL
  // It uses the ModelMap to pass data to the view
  // The view will be resolved to "welcome.jsp" or "welcome.html" based on the view resolver configuration
  // The method returns a String which is the name of the view to be rendered
  // The ModelMap is used to add attributes that can be accessed in the view
@RequestMapping("/welcome")
  public String welcome(ModelMap map) {
	// This method will return the name of the view to be rendered
	// In this case, it will return "welcome" which corresponds to a view named "welcome.jsp"
	  map.addAttribute("message", "Welcome to the First MVC Controller!");
	  map.addAttribute("names",dataservice.getNames());
	  sessionCounter.increment();
	  applicationCounter.increment();
	  map.addAttribute("sessionCount", sessionCounter.getCount());
	  map.addAttribute("applicationCount", applicationCounter.getCount());
	  return "home";
  }
}
