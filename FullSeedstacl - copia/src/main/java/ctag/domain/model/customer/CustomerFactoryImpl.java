package ctag.domain.model.customer;

import org.seedstack.business.domain.BaseFactory;

public class CustomerFactoryImpl extends BaseFactory<Customer> implements CustomerFactory{

@Override
public Customer createCustomer(String name, int age) {
  
  System.out.println("porieorieworiew\noewroewroew\neowriepworoew\roewpriwoe");


 Customer customer=create();
 System.out.println(customer.toString());
 customer.setIdCustomer(new CustomerId(3));
 customer.setAge(age);
 customer.setName(name); 
  // TODO Auto-generated method stub
  return customer;
}

}
