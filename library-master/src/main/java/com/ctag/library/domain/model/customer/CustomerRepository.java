package com.ctag.library.domain.model.customer;

import java.util.List;

import org.seedstack.business.domain.Repository;

public interface CustomerRepository extends Repository<Customer, CustomerId> {

  List<Customer> customerList();

  List<Customer> getCustomerBy(String column, String value);

}
