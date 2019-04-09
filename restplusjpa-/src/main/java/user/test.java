package user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Entities.Departament;
import Entities.Employee;

public class test {
  public static void main(String args[]) {


    testing();
     // createemployee(); 
      //listdeps();
      //System.out.println("sdsdsdsdsdsdsd");      
      //listemployees();
    
  }
  
  public static void testing(){
    
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("employ");
    EntityManager em=emf.createEntityManager(); 
    
    Departament d=em.find(Departament.class,3);
    //Employee e=em.find(Employee.class,88);
   d.setBoss(null);;
   try {
   em.getTransaction().begin();
   em.persist(d);
   em.getTransaction().commit();

   }catch(javax.persistence.RollbackException ex) {
       System.out.println(ex.getMessage());
   }

   
   em.close();
   emf.close();   
   
  }
  
  
  public static void createtdep() {
    
    
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("employ");
    EntityManager em=emf.createEntityManager();    
    Departament d=new Departament("sales");
    try {
    em.getTransaction().begin();
    em.persist(d);
    em.getTransaction().commit();

    }catch(javax.persistence.RollbackException ex) {
        System.out.println(ex.getMessage());
    }

    
    em.close();
    emf.close();   
    
    
  }
  
  public static void listemployees() {
    
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("employ");
    EntityManager em=emf.createEntityManager();     
       
    TypedQuery<Employee> query = em.createQuery("SELECT p FROM Employee p", Employee.class);
    List<Employee> results = query.getResultList();

    results.forEach(n->{System.out.print("\n"+n.getId()+"  name: "+n.getName());
    if(n.getDept()!=null) {System.out.print("  dept:"+n.getDept().getName());}});
    results.get(0).getName();
    
    em.close();
    emf.close();  
  }
  
  public static void listdeps() {
    
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("employ");
    EntityManager em=emf.createEntityManager();     
       
    TypedQuery<Departament> query = em.createQuery("SELECT p FROM Departament p", Departament.class);
    List<Departament> results = query.getResultList();
    results.forEach((n)->System.out.println(n.getName()));
    
    
    em.close();
    emf.close();  
  }
  
  public static void createemployee() {
    
    
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("employ");
    EntityManager em=emf.createEntityManager();    
    Employee d=new Employee("nuw",42,1212);
    /*
    TypedQuery<Departament> query = em.createQuery("SELECT p FROM Departament p", Departament.class);
    List<Departament> results = query.getResultList();
    d.setDept(results.get(0));
    results.get(0).getEmployees().add(d);*/
    
    
    
    try {
    em.getTransaction().begin();
    em.persist(d);
    em.getTransaction().commit();

    }catch(javax.persistence.RollbackException ex) {
        System.out.println(ex.getMessage());
    }

    
    em.close();
    emf.close();   
    
    
  }

}
