package org.videofuture.renter.domain.model.customer;

import org.seedstack.business.domain.Factory;

public interface CustomerFactory extends Factory<Customer>{
  public Customer create(String name);
}
