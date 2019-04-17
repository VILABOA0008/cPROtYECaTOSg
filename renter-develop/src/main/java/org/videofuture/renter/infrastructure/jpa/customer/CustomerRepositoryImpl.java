package org.videofuture.renter.infrastructure.jpa.customer;

import org.seedstack.jpa.BaseJpaRepository;
import org.videofuture.renter.domain.model.customer.Customer;
import org.videofuture.renter.domain.model.customer.CustomerId;
import org.videofuture.renter.domain.model.customer.CustomerRepository;

public class CustomerRepositoryImpl extends BaseJpaRepository<Customer, CustomerId>
    implements CustomerRepository {
}
