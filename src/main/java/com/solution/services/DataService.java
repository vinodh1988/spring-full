package com.solution.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.solution.entities.Person;

@Service
public class DataService {
	List<Person> persons = new ArrayList<>();
	{
		persons.add(new Person(1, "Alice", "New York"));
		persons.add(new Person(2, "Bob", "Los Angeles"));
		persons.add(new Person(3, "Charlie", "Chicago"));
		persons.add(new Person(4, "Diana", "Houston"));
		persons.add(new Person(5, "Ethan", "Phoenix"));
		persons.add(new Person(6, "Fiona", "Philadelphia"));
		persons.add(new Person(7, "George", "San Antonio"));
		persons.add(new Person(8, "Hannah", "San Diego"));
		persons.add(new Person(9, "Ian", "Dallas"));
		persons.add(new Person(10, "Julia", "San Jose"));
	} 
  
 public String[] getNames() {
	  String[] names = {"Alice", "Bob", "Charlie", "Diana", "Ethan", "Fiona", "George", "Hannah", "Ian", "Julia"};	
	  return names;
  }
  
  public List<Person> getPeople() {
	  return persons;
  }
}
