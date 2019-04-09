package services;

 
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import Entities.Departament;
import Entities.Employee;
import user.Methods;
  
@Path("/serv")
public class Resource_Controller{
  Methods m=new Methods();
  
    @GET
    @Path("/{name}")
    public Response getMsg(@PathParam("name") String name,@QueryParam("a") String a,@QueryParam("b") int b) {
  
        String output = "Welcome   : " + name+" "+a+"  "+b;
  
        return Response.status(200).entity(output).build();
  
    }
    
    @GET
    @Path("/emp/create")
    public String createEmployee(@QueryParam("name") String name,@QueryParam("age") 
            int age,@QueryParam("salary") float salary) {

      int id= m.createEmployee(name, age, salary);
      String output="User "+name+"  whith id  "+id+" has been created";      
      
      return output;
    }
    
    
    @GET
    @Path("/dept/create")
    public String createDepartament(@QueryParam("name") String name) {

      int id= m.creaateDepartament(name);
      String output="Departament "+name+"  whith id  "+id+" has been created";      
      
      return output;
    }
    
    @GET
    @Path("/dept/listall")
    public String alldepartaments(){
      
      String output="";
      List<Departament> results=m.listAllDepartaments();
      
      for(Departament emp:results) {
        output+="Id:"+emp.getId_dep()+"  Name:"+emp.getName();
      }

        return output;
    }
    
    @GET
    @Path("/emp/listall")
    public String allEmployees(){
      
      String output="";
      List<Employee> results=m.listallEmployees();
      
      for(Employee emp:results) {
        output+="Id:"+emp.getId()+"  Name:"+emp.getName()+"  Age:"+emp.getAge()+"  salary:"+emp.getSalary()+"\n";        
      }

      return output;
    }
    
    @GET
    @Path("dep/findbyid/")
    public String finddepartament(@QueryParam("id") int id){
      
      Departament e=m.findDepart(id);
      String  output="USER \nId:"+e.getId_dep()+"  Name:"+e.getName();
      if (e.getBoss()!=null) {output+="  Boss name:"+e.getBoss().getName();}
          
      return output;
    }

    
    @GET
    @Path("emp/findbyid/")
    public String findemployee(@QueryParam("id") int id){
      
      Employee e=m.findEmpl(id);
      String  output="USER \nId:"+e.getId()+"  Name:"+e.getName()+"  Age:"+e.getAge()+"  salary:"+e.getSalary();
          
      return output;
    }
}