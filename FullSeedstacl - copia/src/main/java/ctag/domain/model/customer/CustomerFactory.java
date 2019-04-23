package ctag.domain.model.customer;

import org.seedstack.business.domain.Factory;

public interface CustomerFactory extends Factory<Customer>{
  
  Customer createCustomer(String name, int age);

}
