package methods;

//ONLY FOR TESTING
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import Entities.Employee;
import Entities.Proyects;



public class test {
  public static void main(String args[]) {
    others.allprojectcosts();
    //testing();
    
    
  }
 
  
  public static void testing(){
   
    
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("employ");
    EntityManager em=emf.createEntityManager();     
    CriteriaBuilder cb = em.getCriteriaBuilder();
    

    CriteriaQuery<Employee> cq2 = cb.createQuery(Employee.class);
    Root<Employee> emp2 = cq2.from(Employee.class);
    cq2.select(emp2);
    TypedQuery<Employee> tq2 = em.createQuery(cq2);
    List<Employee> results2 = tq2.getResultList();
  
    
    CriteriaQuery<Proyects> cq = cb.createQuery(Proyects.class);
    Root<Proyects> emp = cq.from(Proyects.class);

    cq.select(emp);


    TypedQuery<Proyects> tq = em.createQuery(cq);
    List<Proyects> results = tq.getResultList();

    Random r=new Random();
    em.getTransaction().begin();
    results.forEach(n->{System.err.println(n);
    int c=r.nextInt(15);
    int cc=0;
    while(cc<c) {
      n.getEmployee().add(results2.get(r.nextInt(results2.size())));
      cc++;
    }

    
    
    });
    em.getTransaction().commit();
    
//    SELECT * FROM employe WHERE id IN (SELECT empl FROM empl_proy WHERE proy=(SELECT id_proy FROM proyects WHERE NAME=66))
    
    




    
    
    
    
    
/*

   // ParameterExpression<String> p = cb.parameter(String.class);
  //  query.setParameter(p, "66");





*/
      }
  }
  


/*

CriteriaBuilder cb=em.getCriteriaBuilder();
CriteriaQuery<Proyects> q=cb.createQuery(Proyects.class);
Root<Proyects> c=q.from(Proyects.class);
q.select(c);

TypedQuery<Proyects> query = em.createQuery(q);
  List<Proyects> results = query.getResultList();

results.forEach(n->System.err.println(n.getId()+"  "+n.getAnual_cost()));

*/