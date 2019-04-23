package ctag.domain.model.shop;

import org.seedstack.business.domain.Factory;

public interface ShopFactory extends Factory<Shop>{
  
  Shop createShop(String nameShop);

}
