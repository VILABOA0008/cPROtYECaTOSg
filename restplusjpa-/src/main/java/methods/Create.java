package methods;

import Entities.Departament;
import Entities.Employee;
import Entities.Proyects;

public class Create {
  final static String EMP = "employ";
  

  public static int createEmployee(String name, int age, float salary) {

    Employee emp = new Employee(name, age, salary);
    Employee aux = (Employee) others.save(emp);

    return aux.getId();
  }
  
  public static int createProyect(String name, int dep) {
  Departament d=(Departament)others.find(dep,'d');
    Proyects emp = new Proyects(name,d);
    Proyects aux = (Proyects) others.save(emp);

    return aux.getId();
  }

  public static int creaateDepartament(String name) {
    Departament dept = new Departament(name);
    Departament aux = (Departament) others.save(dept);

    return aux.getId_dep();
  }
}
