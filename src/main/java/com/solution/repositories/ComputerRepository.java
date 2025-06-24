package com.solution.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solution.entities.Computer;

public interface ComputerRepository  extends JpaRepository<Computer, Integer> {

	// Custom query methods can be defined here if needed
	// For example:
	// List<Computer> findByName(String name);
	// List<Computer> findByManufacturer(String manufacturer);

}
