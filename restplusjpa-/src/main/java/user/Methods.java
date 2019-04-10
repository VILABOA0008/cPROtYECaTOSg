package user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Entities.Departament;
import Entities.Employee;





public class Methods {
  
final static String EMP="employ";
  
  public void asignBoss(int idboss,int id_dep) {    
    
    //por implementar
    Employee emp=(Employee)find(idboss, 'e');
    Departament dep=(Departament)find(id_dep, 'd');
    dep.setBoss(emp);
    
    save(dep);
  }
  
  public void asignEmployee(int id_employee,int id_dep) {
    
    EntityManagerFactory emf=Persistence.createEntityManagerFactory(EMP);
    EntityManager em=emf.createEntityManager();    

    Employee emp= em.find(Employee.class,id_employee);
    Departament dep=  em.find(Departament.class,id_dep);
    em.getTransaction().begin();
    dep.getEmployees().add(emp);
    em.getTransaction().commit();

    dep.getEmployees().forEach(n->System.out.println(n.getId()));

  }
  
  public Object find(int id,char t) {
    
    EntityManagerFactory emf=Persistence.createEntityManagerFactory(EMP);
    EntityManager em=emf.createEntityManager();    
    Object o=null;
    switch(t) {
    case 'e':   o=em.find(Employee.class,id);break;
    case 'd':  o=em.find(Departament.class,id);break;    
    }    
    
    return o;    
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
    EntityManagerFactory emf=Persistence.createEntityManagerFactory(EMP);
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
    Departament d=(Departament)find(id,'d');
    return d;
  }
  
  public Employee findEmpl(int id) {
    Employee e=(Employee)find(id,'e');
    return e;
  }
  

  
  public List<Employee>listallEmployees() {
    
    EntityManagerFactory emf=Persistence.createEntityManagerFactory(EMP);
    EntityManager em=emf.createEntityManager();     
       
    TypedQuery<Employee> query = em.createQuery("SELECT p FROM Employee p", Employee.class);
    List<Employee> results = query.getResultList();

    em.close();
    emf.close();

    return results;    
  }
  
  
  public  List<Departament> listAllDepartaments() {
    
    EntityManagerFactory emf=Persistence.createEntityManagerFactory(EMP);
    EntityManager em=emf.createEntityManager();     
       
    TypedQuery<Departament> query = em.createQuery("SELECT p FROM Departament p", Departament.class);
    List<Departament> results = query.getResultList();
    
    em.close();
    emf.close();
    
    return results;
  }

}