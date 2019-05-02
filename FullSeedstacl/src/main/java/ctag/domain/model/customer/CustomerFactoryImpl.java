package ctag.domain.model.customer;

import java.util.Set;

import org.seedstack.business.domain.BaseFactory;

import ctag.domain.model.shop.Shop;

public class CustomerFactoryImpl extends BaseFactory<Customer> implements CustomerFactory {

  @Override
  public Customer createCustomer(String name, int age, Set<Shop> shops, float money) {

    Customer customer = create();

    customer.setAge(age);
    customer.setName(name);
    customer.setMoney(money);
    // TODO Auto-generated method stub
    return customer;
  }

}
