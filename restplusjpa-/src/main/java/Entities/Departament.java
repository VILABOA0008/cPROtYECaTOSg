package Entities;

import java.util.HashSet; 
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Departaments")
public class Departament {
  
  @Id @GeneratedValue
  int id_dep;
  
  @Column(name="name")
  String name;
  
  
  
@JoinColumn(name = "dept")
@OneToMany
private Set<Employee> employees=new HashSet<>();

@JoinColumn(name = "departament")
@OneToMany
private Set<Proyects> proyects=new HashSet<>();

@OneToOne
@JoinColumn(name = "boss")
private Employee boss;
  

  public Set<Proyects> getProyects() {
  return proyects;
}

public void setProyects(Set<Proyects> proyects) {
  this.proyects = proyects;
}

  public Departament() {}
  
  public Departament(String name) {
    super();
    this.name = name;

  }
  public int getId_dep() {
    return id_dep;
  }
  public void setId_dep(int id_dep) {
    this.id_dep = id_dep;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public Set<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(Set<Employee> employees) {
    this.employees = employees;
  }

  public Employee getBoss() {
    return boss;
  }

  public void setBoss(Employee boss) {
    this.boss = boss;
  }

  
  

  
  

}
