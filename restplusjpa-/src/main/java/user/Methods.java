package user;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Entities.Departament;
import Entities.Employee;





public class Methods {
  
  public  List<Departament> listAllDepartaments() {
    
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("employ");
    EntityManager em=emf.createEntityManager();     
       
    TypedQuery<Departament> query = em.createQuery("SELECT p FROM Departament p", Departament.class);
    List<Departament> results = query.getResultList();

    
    
    em.close();
    emf.close();
    
    return results;
  }
  
  public int createEmployee(String name,int age,float salary) {
    
    Employee emp=new Employee(name,age,salary);    
    
    Employee aux=(Employee)save(emp); 
    
    return aux.getId();    
  }
  
  
  public int creaateDepartament(String name) {
    
    Departament dept=new Departament(name);    
    
    Departament aux=(Departament)save(dept); 
    
    return aux.getId_dep();    
  }
  
  
  public Object  save(Object o) {
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("employ");
    EntityManager em=emf.createEntityManager();    
    
    try {
      
    em.getTransaction().begin();
    em.persist(o);
    em.getTransaction().commit();
    
    em.close();
    emf.close();
    
  }catch(javax.persistence.RollbackException ex) {
    System.out.println(ex.getMessage());  }
    
    return o;
    
  }
  
  
  public Departament findDepart(int id) {
    
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("employ");
    EntityManager em=emf.createEntityManager();     
      
    Departament e=em.find(Departament.class,id);
    return e;
  }
  
  public Employee findEmpl(int id) {
    
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("employ");
    EntityManager em=emf.createEntityManager();     
      
    Employee e=em.find(Employee.class,id);
    return e;
  }
  
  public List<Employee>listallEmployees() {
    
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("employ");
    EntityManager em=emf.createEntityManager();     
       
    TypedQuery<Employee> query = em.createQuery("SELECT p FROM Employee p", Employee.class);
    List<Employee> results = query.getResultList();

    em.close();
    emf.close();

    return results;    
  }

}














