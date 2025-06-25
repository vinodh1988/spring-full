package com.solution.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "departments")
public class Department {
  @Id
  private Integer dno;
  @jakarta.persistence.Column
  private String dname;
  
  @OneToMany(mappedBy = "dept",cascade = CascadeType.ALL)
  private Set<Employee> employees;
  
  public Department() {
	// Default constructor
  }
  public Department(Integer dno, String dname) {
	  	this.dno = dno;
	this.dname = dname;
  }
public Integer getDno() {
	return dno;
}
public void setDno(Integer dno) {
	this.dno = dno;
}
public String getDname() {
	return dname;
}
public void setDname(String dname) {
	this.dname = dname;
}
  
public Set<Employee> getEmployees() {
	return employees;
}
public void setEmployees(Set<Employee> employees) {
	this.employees = employees;
}
}
