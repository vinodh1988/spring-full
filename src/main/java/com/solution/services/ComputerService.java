package com.solution.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solution.entities.Computer;
import com.solution.repositories.ComputerRepository;
import com.solution.utilities.RecordAlreadyExistsException;

@Service
public class ComputerService {
  @Autowired
  private ComputerRepository computerRepository;
  
  public List<Computer> getComputers() {
	  
	return computerRepository.findAll();
  }
//  /Save method is not only used for insertion but also updation
  public void addComputer(Computer computer) throws RecordAlreadyExistsException {
      Computer c= computerRepository.findByCno(computer.getCno());
      if(c != null) 
    	  throw new RecordAlreadyExistsException();
	  computerRepository.save(computer);
  }
  
}
