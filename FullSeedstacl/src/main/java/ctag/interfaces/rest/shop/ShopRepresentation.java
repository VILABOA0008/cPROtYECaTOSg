package ctag.interfaces.rest.shop;

import java.util.HashSet;
import java.util.Set;

import org.seedstack.business.assembler.FactoryArgument;

import ctag.domain.model.customer.Customer;
import ctag.domain.model.product.Product;

public class ShopRepresentation {
  

  
  private Set<Product> products = new HashSet<>();
  private String nameShop;
  private Set<Customer> customers=new HashSet<>();

  @FactoryArgument(index=0) 
  public String getNameShop() {
    return nameShop;
  }
  public void setNameShop(String nameShop) {
    this.nameShop = nameShop;
  }
  @FactoryArgument(index=1) 
  public Set<Customer> getCustomers() {
    return customers;
  }
  public void setCustomers(Set<Customer> customers) {
    this.customers = customers;
  }
  @FactoryArgument(index=2) 
  public Set<Product> getProducts() {
    return products;
  }
  public void setProducts(Set<Product> products) {
    this.products = products;
  }



 

}
