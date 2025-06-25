package com.solution.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.solution.entities.Computer;
import com.solution.services.ComputerService;
import com.solution.utilities.RecordAlreadyExistsException;
import com.solution.utilities.RecordNotFoundException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/computers")
@Tag(name = "Computer API", description="All the operations of computer entity")
public class ComputerController {

	@Autowired
	private ComputerService computerService;
	
	@GetMapping("")
	public List<Computer> getComputers(@RequestParam(required = false) Double min,@RequestParam(required=false) Double max) throws RecordNotFoundException{
		List<Computer> computers = null;
		System.out.println("Min Price: " + min + ", Max Price: " + max);
		if (min != null && max != null) {
			computers = computerService.getComputersByPrice(min, max);
		}
		else if (min != null) {

			computers = computerService.getComputersByPrice(min, Double.MAX_VALUE);
		}
		else if (max != null) {
			// If only max is provided, set min to 0
			computers = computerService.getComputersByPrice(0.0, max);
		} 
		else
			
			computers = computerService.getComputers();
			
	    return computers;
	}
	@Operation(
			   summary="Get computer by cno",
			   description="Get Computer by passing cono "
			)
			@ApiResponses(
				 value = {
						 @ApiResponse(responseCode="200", description="Computer found with given cno"),
						 @ApiResponse(responseCode="400", description="if No computer exists with given cno"),
						 @ApiResponse(responseCode="500", description="Server related error")
				 }	
				)
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
	
	@DeleteMapping("/{cno}")
	public ResponseEntity<String> deleteComputer(@PathVariable int cno) throws RecordNotFoundException
	{
		computerService.deleteComputer(cno);
		return ResponseEntity.status(HttpStatus.OK).body("record deleted successfully");
	}
}
