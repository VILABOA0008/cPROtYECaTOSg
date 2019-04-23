package ctag.interfaces.rest.customer;

import org.seedstack.business.assembler.AggregateId;
import org.seedstack.business.assembler.FactoryArgument;

public class CustomerRepresentation {

  //private int idcustomer;
  private String name;
  private int age;
  
  /*
  @AggregateId
  @FactoryArgument(index = 0)
  public int getIdcustomer() {
    return idcustomer;
  }
  public void setIdcustomer(int idcustomer) {
    this.idcustomer = idcustomer;
  }*/
  @FactoryArgument(index = 0)
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  @FactoryArgument(index = 1)
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  
  
  
}
