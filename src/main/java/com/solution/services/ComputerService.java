package com.solution.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solution.entities.Computer;
import com.solution.repositories.ComputerRepository;

@Service
public class ComputerService {
  @Autowired
  private ComputerRepository computerRepository;
  
  public List<Computer> getComputers() {
	return computerRepository.findAll();
  }
  
  public void addComputer(Computer computer) {
      computerRepository.save(computer);
  }
  
}
