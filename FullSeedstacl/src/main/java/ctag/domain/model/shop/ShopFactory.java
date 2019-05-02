package ctag.domain.model.shop;

import java.util.Set;

import org.seedstack.business.domain.Factory;

import ctag.domain.model.customer.Customer;
import ctag.domain.model.product.Product;

public interface ShopFactory extends Factory<Shop>{
  
  Shop createShop(String nameShop,Set<Customer> customers, Set<Product> products );

}
