package ctag.interfaces.rest;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataParam;
import org.seedstack.jpa.Jpa;
import org.seedstack.jpa.JpaUnit;
import org.seedstack.seed.transaction.Transactional;

import ctag.application.Assign;
import ctag.application.Create;
import ctag.application.Lists;
import ctag.domain.model.Departament;
import ctag.domain.model.Employee;
import ctag.domain.model.Proyects;


@Transactional
@JpaUnit("myUnit")
@Jpa
@Path("hello")
public class HelloResource {
  @GET
  public String hello() {
    return "Hello World!";
  }

  @Inject
  private EntityManager em;

  // LISTS

  @GET
  @Produces(MediaType.TEXT_HTML)
  @Path("/emp/listall")
  public String allEmployees() {

    String output = "";
    List<Employee> emp = Lists.listallEmployees(em);
    String title = "<table style=\"width:100%\" border=\" 1px solid black \"><tr><th>ID</th><th>NAME</th><th>AGE</th><th>SALARY</th>  </tr>";
    for (Employee e : emp) {
      output += "<tr><td>" + e.getId() + "</td><td>" + e.getName() + "</td><td>" + e.getAge()
          + "</td><td>" + e.getSalary() + "</td>  </tr>";
    }
    return "<html> " + "<title></title>" + "<body><h1>" + title + output
        + "</table></h1></body>" + "</html> ";
  }
  


  @GET
  @Path("dep/listall")
  public String listaAllDept() {

    List<Departament> dep = Lists.listAllDepartaments(em);
    String output = "";
    String title = "<table style=\"width:100%\" border=\" 1px solid black \"><tr><th>ID</th><th>NAME</th><th>BOSS</th>  </tr>";
    for (Departament e : dep) {
      output += "<tr><td>" + e.getId_dep() + "</td><td>" + e.getName() + "</td>";
      if (e.getBoss() != null) {
        output += "<td>" + e.getBoss().getName() + "</td> </tr>";
      }
    }
    return "<html> " + "<title></title>" + "<body><h1>" + title + output
        + "</table></h1></body>" + "</html> ";

  }

  @GET
  @Path("pro/listall")
  public String listaAllProy() {

    List<Proyects> pro = Lists.listAllProyects(em);
    String output = "";
    String title = "<table style=\"width:100%\" border=\" 1px solid black \"><tr><th>ID</th><th>NAME</th><th>ANUAL COST</th><th>BOSS</th>  </tr>";
    for (Proyects p: pro) {
      output += "<tr><td>" + p.getId() + "</td><td>" + p.getName() + "</td><td>" + p.getAnual_cost() + "</td>";
      if (p.getDirector() != null) {output += "<td>" + p.getDirector().getName() + "</td> </tr>";
      }
    }
    return "<html> " + "<title></title>" + "<body><h1>" + title + output
        + "</table></h1></body>" + "</html> ";

  }
  // CREATES

  @POST
  @Path("/emp/create")
  public String createEmployee(@FormDataParam("name") String name, @FormDataParam("age") int age,
      @FormDataParam("salary") float salary) {

    Employee e = new Employee(name, age, salary);
    em.persist(e);

    return "Employee: " + name + "  whith id  " + e.getId() + " has been created";
  }


  @POST
  @Path("/dept/create")
  public String createDepartament(@FormDataParam("name") String name) {
    int id = Create.creaateDepartament(name, em);

    return "Departament " + name + "  whith id  " + id + " has been created";
  }
  


  @POST
  @Path("/proy/create")
  public String createProyect(@FormDataParam("name") String name, @FormDataParam("dept") int dep) {

    int id = Create.createProyect(name, dep, em);

    return "Proyect: " + name + "  whith id  " + id + " has been created";
  }

  // FIND
  @GET
  @Path("dep/findbyid/")
  public String finddepartament(@QueryParam("id") int id) {

    Departament e = em.find(Departament.class, id);
    String output = "Id:" + e.getId_dep() + "  Name:" + e.getName();
    if (e.getBoss() != null) {
      output += "  Boss name:" + e.getBoss().getName();
    }

    return output;
  }


  @GET
  @Produces(MediaType.TEXT_HTML)
  @Path("emp/findsalary/")
  public String findbysal(@QueryParam("sal") float sal) {
    String output = "";
    List<Employee> results = Lists.EmployeesSalary(sal, em);
    String title = "<table style=\"width:100%\" border=\" 1px solid black \"><tr><th>ID</th><th>NAME</th><th>AGE</th><th>SALARY</th>  </tr>";
    for (Employee emp : results) {
      output += "<tr><td>" + emp.getId() + "</td><td>" + emp.getName() + "</td><td>" + emp.getAge()
          + "</td><td>" + emp.getSalary() + "</td>  </tr>";
    }
    return "<html> " + "<title></title>" + "<body><h1>" + title + output
        + "</table></h1></body>" + "</html> ";
  }


  @GET
  @Path("emp/findbyid/")
  public String findemployee(@QueryParam("id") int id) {

    Employee e = em.find(Employee.class, id);

    return "USER \nId:" + e.getId() + "  Name:" + e.getName() + "  Age:" + e.getAge() + "  salary:"
        + e.getSalary();
  }
  
  //ASIGN
  
  @POST
  @Produces(MediaType.TEXT_HTML) 
  @Path("/dept/asignemp")
  public String asignEmployee(@FormDataParam("id_emp") int id_emp,@FormDataParam("id_dep") int id_dep) {
    
    Assign.asignEmployee(id_emp, id_dep,em);
    String output="Employee "+id_emp+" has been asigned to Departament :"+id_dep;
    return "<html> " + "<title></title>"  + "<body><h1>" + output + "</h1></body>" + "</html> "; 
    
  }
  
  @POST
  @Produces(MediaType.TEXT_HTML) 
  @Path("/dept/asignboss")
  public String asigBoss(@FormDataParam("id_emp") int id_emp,@FormDataParam("id_dep") int id_dep) {
    
    Assign.asignBoss(id_emp, id_dep,em);
    String output=id_emp+"  is the boss of the departament "+id_dep;
    
    return "<html> " + "<title></title>"  + "<body><h1>" + output + "</h1></body>" + "</html> "; 
  }
  
  
  @PUT
  @Path("emp/modSal")
  public String modifySalary(@FormDataParam("id") int id, @FormDataParam("sal") float sal) {
    Employee e=em.find(Employee.class, id);
    e.setSalary(sal);
    
    return "Salary of Employee: "+id+"  is now:"+sal;
  }
}
