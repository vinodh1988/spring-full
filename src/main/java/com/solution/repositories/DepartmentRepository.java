package com.solution.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solution.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
