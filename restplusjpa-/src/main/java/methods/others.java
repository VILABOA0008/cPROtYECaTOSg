package methods;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import Entities.Departament;
import Entities.Employee;
import Entities.Proyects;

public class others {
  final static String EMP = "employ";
  public static Object save(Object o) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory(EMP);
    EntityManager em = emf.createEntityManager();

    try {
      em.getTransaction().begin();
      em.persist(o);
      em.getTransaction().commit();

      em.close();
      emf.close();

    } catch (javax.persistence.RollbackException ex) {
      System.out.println(ex.getMessage());
    }
    return o;
  }
  
  public static Object find(int id, char t) {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory(EMP);
    EntityManager em = emf.createEntityManager();
    Object o = null;
    switch (t) {
    case 'e':
      o = em.find(Employee.class, id);
      break;
    case 'd':
      o = em.find(Departament.class, id);
      break;
    }
    em.close();
    emf.close();

    return o;
  }
  
  public static void projectcosts(int id_pro) {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("employ");
    EntityManager em = emf.createEntityManager();
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
    Root<Employee> emp = cq.from(Employee.class);
    cq.select(emp);

    TypedQuery<Employee> tp = em.createQuery(cq);
    List<Employee> emps = tp.getResultList();

    Proyects p = em.find(Proyects.class, id_pro);

    double sal = emps
        .stream()
        .filter(a -> a.getProy().contains(p))
        .mapToDouble(Employee::getSalary)
        .sum() * 12;

    System.out.println(sal);
    em.close();
    emf.close();
  }
  
  public static void allprojectcosts() {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("employ");
    EntityManager em = emf.createEntityManager();
  TypedQuery<Proyects> q = em.createQuery("SELECT p FROM Proyects p", Proyects.class);
  List<Proyects> proys = q.getResultList();
  
  TypedQuery<Employee> query = em.createQuery("SELECT p FROM Employee p", Employee.class);
  List<Employee> emps = query.getResultList();
  em.getTransaction().begin();
  
  proys.forEach(
      n->n.setAnual_cost((float)emps.stream()
          .filter(a->a.getProy().contains(n)) 
          .mapToDouble(Employee::getSalary) 
          .sum()*12));   
  
  em.getTransaction().commit();
  proys.forEach(n->System.out.println(n.getAnual_cost()));
  

  em.close();
  emf.close();
}
}
