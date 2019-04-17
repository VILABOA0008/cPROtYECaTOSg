package ctag.application;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ctag.domain.model.Departament;
import ctag.domain.model.Employee;
import ctag.domain.model.Employee_;
import ctag.domain.model.Proyects;

public class Lists {
  final static String EMP = "employ";
  
  public static List<Employee> listallEmployees(EntityManager em) {

    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
    Root<Employee> emp = cq.from(Employee.class);
    cq.select(emp);
    TypedQuery<Employee> tp = em.createQuery(cq);
    List<Employee> results = tp.getResultList();


    return results;
  }
  public static List<Employee> EmployeesSalary(float sal,EntityManager em) {

    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
    Root<Employee> emp = cq.from(Employee.class);
    ParameterExpression<Float> p=cb.parameter(Float.class,"sal");
    Predicate a=cb.gt(emp.get(Employee_.salary),p);
    cq.select(emp).orderBy(cb.asc(emp.get(Employee_.salary))).where(a);

    TypedQuery<Employee> tq = em.createQuery(cq);
    tq.setParameter("sal",sal);
    List<Employee> results = tq.getResultList();

    return results;
  }
  
  
  public static List<Departament> listAllDepartaments(EntityManager em ){

    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Departament> cq = cb.createQuery(Departament.class);
    Root<Departament> emp = cq.from(Departament.class);
    cq.select(emp);
    TypedQuery<Departament> tp = em.createQuery(cq);
    List<Departament> results = tp.getResultList();


    return results;
  }
  
  
  public static List<Proyects> listAllProyects(EntityManager em ){

    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Proyects> cq = cb.createQuery(Proyects.class);
    Root<Proyects> emp = cq.from(Proyects.class);
    cq.select(emp);
    TypedQuery<Proyects> tp = em.createQuery(cq);
    List<Proyects> results = tp.getResultList();

    return results;
  }
  
}
