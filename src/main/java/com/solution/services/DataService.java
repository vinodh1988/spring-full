package com.solution.services;

import org.springframework.stereotype.Service;

@Service
public class DataService {
  public String[] getNames() {
	  String[] names = {"Alice", "Bob", "Charlie", "Diana", "Ethan", "Fiona", "George", "Hannah", "Ian", "Julia"};	
	  return names;
  }
}
