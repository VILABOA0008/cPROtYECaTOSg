package ctag.domain.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Proyects {
  @Column(name="id_proy")
  @Id @GeneratedValue
  private int id;
  @Column(name="name")
  private String name;
  @ManyToOne
  @JoinColumn(name="departament")
  private Departament departament;
  
  @Column(name="anual_cost")
  private float anual_cost;

  @ManyToMany
  @JoinTable(name="empl_proy",joinColumns = {@JoinColumn(name="proy")},
      inverseJoinColumns = {@JoinColumn(name="empl")})
  private Set<Employee> employee = new HashSet<Employee>();

  
  @OneToOne
  @JoinColumn(name="director")
  private Employee director;
  



  
  public Proyects(String name, Departament departament) {
    super();
    this.name = name;
    this.departament = departament;
  }



  public Set<Employee> getEmployee() {
    System.out.println("Ahora ha pasado algo");
    return employee;
  }



  public void setEmployee(Set<Employee> employee) {
    this.employee = employee;
  }



  public Proyects() {
    super();
  }


  public int getId() {
    return id;
  }


  public void setId(int id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public Departament getDepartament() {
    return departament;
  }


  public void setDepartament(Departament departament) {
    this.departament = departament;
  }


  public Employee getDirector() {
    return director;
  }


  public void setDirector(Employee director) {
    this.director = director;
  }



  public float getAnual_cost() {
    return anual_cost;
  }



  public void setAnual_cost(float anual_cost) {
    this.anual_cost = anual_cost;
  }
  
  
  

}
