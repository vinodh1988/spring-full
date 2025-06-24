package com.solution.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/firstmvc")
public class FirstMVCController {
  @RequestMapping("/welcome")
  public String welcome() {
	// This method will return the name of the view to be rendered
	// In this case, it will return "welcome" which corresponds to a view named "welcome.jsp"
	return "home";
  }
}
