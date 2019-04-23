package ctag.domain.model.customer;

import java.util.List;

import org.seedstack.business.domain.Repository;
import org.seedstack.jpa.Jpa;

public interface CustomerRepository extends Repository<Customer,CustomerId> {

  List<Customer> customerList();
  
  List<Customer> getCustomersBy();
  
}
