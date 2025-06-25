package com.solution.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solution.entities.Department;
import com.solution.entities.Employee;
import com.solution.repositories.DepartmentRepository;

@Service
public class DepartmentService {
  @Autowired
  private DepartmentRepository departmentRepository;
  
  public List<Department> getAllDepartments() {
	return departmentRepository.findAll();
  }
  
  public void addDepartment(Department department) {
	  for(Employee employee : department.getEmployees()) {
		  employee.setDept(department);
	  }
	  departmentRepository.save(department);
  }
}
