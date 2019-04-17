package org.videofuture.renter.interfaces.dto.customer;

import java.sql.Date;

import org.seedstack.business.domain.BaseFactory;
import org.videofuture.renter.domain.model.customer.Customer;
import org.videofuture.renter.domain.model.customer.CustomerFactory;

public class CustomerFactoryImpl extends BaseFactory<Customer> implements CustomerFactory {

  public Customer create(String name) {
    Customer tmp = this.create();
    tmp.setName(name);
    tmp.setRegisterDate(new Date(new java.util.Date().getTime()));
    return tmp;
  }
}
