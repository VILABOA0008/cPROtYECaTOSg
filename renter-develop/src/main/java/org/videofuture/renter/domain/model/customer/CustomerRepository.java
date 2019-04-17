package org.videofuture.renter.domain.model.customer;

import java.util.List;
import java.util.stream.Collectors;

import org.seedstack.business.domain.Repository;

public interface CustomerRepository extends Repository<Customer, CustomerId> {

  public default List<Customer> listAllCustomers() {
    return this.get(this.getSpecificationBuilder()
        .ofAggregate(Customer.class)
        .all()
        .build())
        .collect(Collectors.toList());
  }
}
