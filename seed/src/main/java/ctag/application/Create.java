package ctag.application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import ctag.domain.model.Departament;
import ctag.domain.model.Employee;
import ctag.domain.model.Proyects;

public class Create {
  final static String EMP = "employ";
  

  public static int createEmployee(String name, int age, float salary,EntityManager em) {

    Employee emp = new Employee(name, age, salary);
    em.persist(emp);;

    return emp.getId();
  }
  
  public static int createProyect(String name, int dep,EntityManager em) {
  Departament d=em.find(Departament.class, dep);
    Proyects emp = new Proyects(name,d);
     em.persist(emp);

    return emp.getId();
  }

  public static int creaateDepartament(String name,EntityManager em) {
    Departament dept = new Departament(name);
em.persist(dept);

    return dept.getId_dep();
  }
}
