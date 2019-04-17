package methods;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entities.Departament;
import Entities.Employee;
import Entities.Proyects;

public class Assign {
  final static String EMP = "employ";

  public static void asignBoss(int idboss, int id_dep) {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("employ");
    EntityManager em = emf.createEntityManager();

    Employee e = em.find(Employee.class, idboss);
    Departament d= em.find(Departament.class, id_dep);

    em.getTransaction().begin();
    d.setBoss(e);
    em.getTransaction().commit();

    em.close();
    emf.close();
  }
  public static void asignEmployeeToProyect(int id_pro, int id_emp) {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("employ");
    EntityManager em = emf.createEntityManager();

    Employee e = em.find(Employee.class, id_emp);
    Proyects p = em.find(Proyects.class, id_pro);

    em.getTransaction().begin();
    e.getProy().add(p);
    em.getTransaction().commit();

    System.out.println(p.getEmployee());

    em.close();
    emf.close();
  }

  public static void asignEmployee(int id_employee, int id_dep) {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory(EMP);
    EntityManager em = emf.createEntityManager();

    Employee emp = em.find(Employee.class, id_employee);
    Departament dep = em.find(Departament.class, id_dep);
    em.getTransaction().begin();
    dep.getEmployees().add(emp);
    em.getTransaction().commit();

    dep.getEmployees().forEach(n -> System.out.println(n.getId()));

    em.close();
    emf.close();
  }
  
  


}
