package ctag.domain.model.product;

import org.seedstack.business.domain.BaseFactory;

import ctag.domain.model.shop.Shop;

public class ProductFactoryImpl extends BaseFactory<Product> implements ProductFactory{


  @Override
  public Product createProduct(float cost, int quantity,Shop shop) {
    
    Product p=create();
    p.setCost(cost);
    p.setQuantity(quantity);
    return p;
  }

}
