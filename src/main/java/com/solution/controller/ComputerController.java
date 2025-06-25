package com.solution.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solution.entities.Computer;
import com.solution.services.ComputerService;

@RestController
@RequestMapping("/api/computers")
public class ComputerController {

	@Autowired
	private ComputerService computerService;
	
	@GetMapping("")
	public List<Computer> getComputers() {
		return computerService.getComputers();
	}
	
	@PostMapping("")
	public ResponseEntity<Object> addComputer(@RequestBody Computer computer) {
		try {
		computerService.addComputer(computer);
		return ResponseEntity.status(HttpStatus.CREATED).body(computer);
		}
		catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
