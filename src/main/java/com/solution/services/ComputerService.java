package com.solution.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solution.entities.Computer;
import com.solution.repositories.ComputerRepository;
import com.solution.utilities.RecordAlreadyExistsException;
import com.solution.utilities.RecordNotFoundException;

@Service
public class ComputerService {
  @Autowired
  private ComputerRepository computerRepository;
  
  public List<Computer> getComputers() {
	  
	return computerRepository.findAll();
  }
  
  public List<Computer> getComputersByPrice(Double minPrice, Double maxPrice) {
	  return computerRepository.getComputersbyPrice(minPrice, maxPrice);
  }

  
  public Computer getComputerByCno(int cno) throws RecordNotFoundException {
	 Computer c= computerRepository.findByCno(cno);
	 if(c == null) 
		 throw new RecordNotFoundException();
	  return computerRepository.findByCno(cno);
  }
  
//  /Save method is not only used for insertion but also updation
  public void addComputer(Computer computer) throws RecordAlreadyExistsException {
      Computer c= computerRepository.findByCno(computer.getCno());
      if(c != null) 
    	  throw new RecordAlreadyExistsException();
	  computerRepository.save(computer);
  }
  
  public void updateComputer(Computer computer) throws RecordNotFoundException {
	  Computer c= computerRepository.findByCno(computer.getCno());
	  if(c == null) 
		  throw new RecordNotFoundException();
	  computer.setBrand(computer.getBrand()!=null ? computer.getBrand() : c.getBrand());
      computer.setCpu(computer.getCpu()!=null ? computer.getCpu() : c.getCpu());
      computer.setRam(computer.getRam()!=null ? computer.getRam() : c.getRam());
	  computer.setDisksize(computer.getDisksize()!=null ? computer.getDisksize() : c.getDisksize());
	  computerRepository.save(computer);
  }
  
  public void deleteComputer(int cno) throws RecordNotFoundException {
	  Computer c= computerRepository.findByCno(cno);
	  if(c == null) 
		  throw new RecordNotFoundException();
	  computerRepository.delete(c);
  }
  
  
}
