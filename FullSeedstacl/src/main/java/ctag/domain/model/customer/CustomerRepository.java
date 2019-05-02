package ctag.domain.model.customer;

import java.util.List;

import org.seedstack.business.domain.Repository;

import ctag.domain.model.shop.Shop;

public interface CustomerRepository extends Repository<Customer, CustomerId> {

  List<Customer> customerList();

  Customer getCustomersById(int id);

  List<Customer> findByAll(String column, String id);

  List<Customer> idShops(int id);

  List<Customer> richClientes(float minMoney);

  List<Customer> vipCustomers(float minCostProducts);
  
  boolean customerDelete(int id);

  Customer  customerModMoney(int id, float money);
}
