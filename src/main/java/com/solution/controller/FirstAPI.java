package com.solution.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solution.entities.Person;
import com.solution.services.DataService;
//not  created in a way that follows the best practices of RESTful API design, but it serves as a basic example of how to create a REST controller in Spring Boot.
@RestController
@RequestMapping("/api/v1/first")
public class FirstAPI {
	
	@Autowired
	private DataService dataService;
  
	@GetMapping("")
	public String firstAPI() {
		return "Hello from First API";
	}
	
	@GetMapping("/names")
	public String[] getNames() {
		return dataService.getNames();
	}
	
	@GetMapping("/people")
	public List<Person> getPeople() {
		return dataService.getPeople();
	}
}
