package ctag.application;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ctag.domain.model.Departament;
import ctag.domain.model.Employee;
import ctag.domain.model.Proyects;

public class others {
  static final  String  EMP = "employ";
  
  
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
