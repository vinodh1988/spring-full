package com.solution.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
