package ctag.domain.model.shop;

import java.util.Set;

import org.seedstack.business.domain.BaseFactory;

import ctag.domain.model.customer.Customer;
import ctag.domain.model.product.Product;

public class ShopFactoryImpl extends BaseFactory<Shop> implements ShopFactory {

  @Override
  public Shop createShop(String nameShop, Set<Customer> customers, Set<Product> products ) {

    Shop shop = create();
    shop.setNameShop(nameShop);

    return shop;
  }

}
