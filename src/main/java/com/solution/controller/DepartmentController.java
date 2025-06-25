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

import com.solution.entities.Department;
import com.solution.services.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
@Autowired
private DepartmentService departmentService;
	@GetMapping("")	
	public List<Department> getDepartments() {
		return departmentService.getAllDepartments();
	}
	
	@PostMapping("")
	public ResponseEntity<Department> addDepartment(@RequestBody Department department)  {
		departmentService.addDepartment(department);
		return ResponseEntity.status(HttpStatus.CREATED).body(department);
	}
}
