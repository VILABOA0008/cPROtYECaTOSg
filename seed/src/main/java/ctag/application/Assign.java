package ctag.application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ctag.domain.model.Departament;
import ctag.domain.model.Employee;
import ctag.domain.model.Proyects;

public class Assign {
  final static String EMP = "employ";

  public static void asignBoss(int idboss, int id_dep,EntityManager em ) {

    Employee e = em.find(Employee.class, idboss);
    Departament d= em.find(Departament.class, id_dep);

    d.setBoss(e);

  }
  public static void asignEmployeeToProyect(int id_pro, int id_emp,  EntityManager em ) {

    Employee e = em.find(Employee.class, id_emp);
    Proyects p = em.find(Proyects.class, id_pro);

    e.getProy().add(p);

  }

  public static void asignEmployee(int id_employee, int id_dep,  EntityManager em ) {

    Employee emp = em.find(Employee.class, id_employee);
    Departament dep = em.find(Departament.class, id_dep);
    dep.getEmployees().add(emp);

    dep.getEmployees().forEach(n -> System.out.println(n.getId()));

  }
  
}
