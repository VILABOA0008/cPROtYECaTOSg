package ctag.domain.model.product;

import org.seedstack.business.domain.Factory;

import ctag.domain.model.shop.Shop;

public interface ProductFactory extends Factory<Product> {
  
  Product createProduct(float cost,int quantity,Shop shop);

}
