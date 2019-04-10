package Entities;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity  
@Table(name="employe")  
public class Employee {
@Id @GeneratedValue
private int id;
@Column(name="name")
private String name;
@Column(name="age")
private int age;
@Column(name="salary")
private float salary;

  
@ManyToOne
@JoinColumn(name = "dept")
Departament dept;

@ManyToMany(mappedBy="employee")
private Set<Proyects> proy = new HashSet<Proyects>();

public Employee(String name, int age, float salary) {
  super();
  
  this.name = name;
  this.age = age;
  this.salary = salary;
}
public Employee() {}


public int getId() {
  return id;
}


public void setId(int id) {
  this.id = id;
}




public Set<Proyects> getProy() {
  return proy;
}
public void setProy(Set<Proyects> proy) {
  this.proy = proy;
}
public Departament getDept() {
  return dept;
}
public void setDept(Departament dept) {
  this.dept = dept;
}

public String getName() {
  return name;
}

public void setName(String name) {
  this.name = name;
}

public int getAge() {
  return age;
}

public void setAge(int age) {
  this.age = age;
}

public float getSalary() {
  return salary;
}

public void setSalary(float salary) {
  this.salary = salary;
}
  


}


