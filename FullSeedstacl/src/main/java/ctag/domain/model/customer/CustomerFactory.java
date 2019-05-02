package ctag.domain.model.customer;

import java.util.Set;

import org.seedstack.business.domain.Factory;

import ctag.domain.model.shop.Shop;

public interface CustomerFactory extends Factory<Customer>{
  
  Customer createCustomer(String name, int age,Set<Shop> shops,float money);

}
