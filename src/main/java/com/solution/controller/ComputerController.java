package com.solution.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.solution.entities.Computer;
import com.solution.services.ComputerService;
import com.solution.utilities.RecordAlreadyExistsException;
import com.solution.utilities.RecordNotFoundException;

@RestController
@RequestMapping("/api/computers")
public class ComputerController {

	@Autowired
	private ComputerService computerService;
	
	@GetMapping("")
	public List<Computer> getComputers() {
		return computerService.getComputers();
	}
	
	@GetMapping("/{cno}")
	public ResponseEntity<Computer> getComputerByCno(@PathVariable int cno) throws RecordNotFoundException
	{
		Computer computer = computerService.getComputerByCno(cno);
		return ResponseEntity.status(HttpStatus.OK).body(computer);
	}
	
	@PostMapping("")
	public ResponseEntity<Computer> addComputer(@RequestBody Computer computer) throws RecordAlreadyExistsException
	{

		computerService.addComputer(computer);
		return ResponseEntity.status(HttpStatus.CREATED).body(computer);
		
	}
	
	@RequestMapping(value="", method = {RequestMethod.PUT, RequestMethod.PATCH})
	public ResponseEntity<String> updateComputer(@RequestBody Computer computer) throws RecordNotFoundException
	{
		if (computer.getCno() == null) {
			throw new IllegalArgumentException("Cno must not be null for update operation");
		}
		computerService.updateComputer(computer);
		return ResponseEntity.status(HttpStatus.OK).body("record updated successfully");
	}
}
