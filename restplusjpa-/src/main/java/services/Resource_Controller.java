package services;

 
import java.util.List; 

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Entities.Departament;
import Entities.Employee;
import methods.Assign;
import methods.Create;
import methods.Lists;
import methods.others;
   
//PROYECTS NOT IMPLMENTED
@Path("/serv")
public class Resource_Controller{

  
    @GET
    @Path("/{name}")
    public Response getMsg(@PathParam("name") String name,@QueryParam("a") String a,@QueryParam("b") int b) {
  
        String output = "Welcome   : " + name+" "+a+"  "+b;
  
        return Response.status(200).entity(output).build();
  
    }
    
    @POST
    @Path("/emp/create")
    public String createEmployee(@FormParam("name") String name,@FormParam("age") 
            int age,@FormParam("salary") float salary) {

      int id= Create.createEmployee(name, age, salary);
      String output="Employee: "+name+"  whith id  "+id+" has been created";      
      
      return output;
    }
    
    @POST
    @Path("/proy/create")
    public String createProyect(@FormParam("name") String name,@FormParam("dept")   int dep) {

      int id= Create.createProyect(name, dep);
      String output="Proyect: "+name+"  whith id  "+id+" has been created";      
      
      return output;
    }
    
    
    
    @POST
    @Produces(MediaType.TEXT_HTML) 
    @Path("/dept/asignemp")
    public String asignEmployee(@FormParam("id_emp") int id_emp,@FormParam("id_dep") int id_dep) {
      
      Assign.asignEmployee(id_emp, id_dep);
      String output="Employee "+id_emp+" has been asigned to "+id_dep;
      return "<html> " + "<title></title>"  + "<body><h1>" + output + "</h1></body>" + "</html> "; 
      
    }
    
    @POST
    @Produces(MediaType.TEXT_HTML) 
    @Path("/dept/asignboss")
    public String asigBoss(@FormParam("id_emp") int id_emp,@FormParam("id_dep") int id_dep) {
      
      Assign.asignBoss(id_emp, id_dep);
      String output=id_emp+"  is the boss of the departament "+id_dep;
      return "<html> " + "<title></title>"  + "<body><h1>" + output + "</h1></body>" + "</html> "; 
      
    }
    
    @POST
    @Path("/dept/create")
    public String createDepartament(@FormParam("name") String name) {

      int id= Create.creaateDepartament(name);
      String output="Departament "+name+"  whith id  "+id+" has been created";      
      
      return output;
    }
    
    @GET
    @Path("/dept/listall")
    public String alldepartaments(){
      
      String output="";
      List<Departament> results=Lists.listAllDepartaments();
      
      for(Departament dep:results) {
        output+="\n Id:"+dep.getId_dep()+"  Name:"+dep.getName();
        if(dep.getBoss()!=null) {output+="  Boss:"+dep.getBoss().getName();}
      }

        return output;
    }
    
    @GET
    @Produces(MediaType.TEXT_HTML) 
    @Path("/emp/listall")
    public String allEmployees(){
      
      String output="";
      List<Employee> results=Lists.listallEmployees();
      String title="<table style=\"width:100%\" border=\" 1px solid black \"><tr><th>ID</th><th>NAME</th><th>AGE</th><th>SALARY</th>  </tr>";
      for(Employee emp:results) {       
        output+="<tr><td>"+emp.getId()+"</td><td>"+emp.getName()+"</td><td>"+emp.getAge()+"</td><td>"+emp.getSalary()+"</td>  </tr>";

      }
      return "<html> " + "<title>" + "Hello Jersey" + "</title>"  + "<body><h1>" + title+output + "</table></h1></body>" + "</html> "; 
      
    }
    
    @GET
    @Path("dep/findbyid/")
    public String finddepartament(@QueryParam("id") int id){
      
      Departament e=(Departament) others.find(id, 'd');
    String output = "Id:"+e.getId_dep()+"  Name:"+e.getName();
      if (e.getBoss()!=null) {output+="  Boss name:"+e.getBoss().getName();}
          
      return output;
    }

    @GET
    @Produces(MediaType.TEXT_HTML) 
    @Path("emp/findsalary/")
    public String findbysal(@QueryParam("sal") float sal){      
      String output="";
      List<Employee> results=Lists.EmployeesSalary(sal);
      String title="<table style=\"width:100%\" border=\" 1px solid black \"><tr><th>ID</th><th>NAME</th><th>AGE</th><th>SALARY</th>  </tr>";
      for(Employee emp:results) {       
        output+="<tr><td>"+emp.getId()+"</td><td>"+emp.getName()+"</td><td>"+emp.getAge()+"</td><td>"+emp.getSalary()+"</td>  </tr>";}

      return "<html> " + "<title>" + "Hello Jersey" + "</title>"  + "<body><h1>" + title+output + "</table></h1></body>" + "</html> "; 
    }
    
    
    
    @GET
    @Path("emp/findbyid/")
    public String findemployee(@QueryParam("id") int id){
      
      Employee e=(Employee) others.find(id, 'e');
      String  output="USER \nId:"+e.getId()+"  Name:"+e.getName()+"  Age:"+e.getAge()+"  salary:"+e.getSalary();
          
      return output;
    }
}


// THING TO DO
//HOW MANY COSTS A PROYECT AT YEAR  ,  ACCORDING WITH HIS EMPLOYEES SALARY LAMBDA
// TRY CREATE A NEW BRANCH MODIFY AND MERGE¿?