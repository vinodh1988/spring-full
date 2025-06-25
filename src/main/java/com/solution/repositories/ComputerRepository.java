package com.solution.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.solution.entities.Computer;

public interface ComputerRepository  extends JpaRepository<Computer, Integer> {

	// Custom query methods can be defined here if needed
	// For example:
	// List<Computer> findByName(String name);
	// List<Computer> findByManufacturer(String manufacturer);
  public Computer findByCno(Integer cno); // Example method to find by cno
  @Query("SELECT c FROM Computer c WHERE c.price BETWEEN :min AND :max")
  public List<Computer> getComputersbyPrice(@Param("min") Double min,@Param("max") Double max); // Example method to find by price range
}
