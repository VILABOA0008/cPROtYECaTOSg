package ctag.interfaces.rest.customer;

import java.util.HashSet;
import java.util.Set;

import org.seedstack.business.assembler.FactoryArgument;

import ctag.domain.model.shop.Shop;

public class CustomerRepresentation {

  //private int idcustomer;
  private String name;
  private int age;
  private Set<Shop> shops=new HashSet<>();
  private float money;
  
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
  @FactoryArgument(index = 2)
  public Set<Shop> getShops() {
    return shops;
  }
  public void setShops(Set<Shop> shops) {
    this.shops = shops;
  }
  @FactoryArgument(index = 3)
  public float getMoney() {
    return money;
  }
  public void setMoney(float money) {
    this.money = money;
  }
  
  
  
}
