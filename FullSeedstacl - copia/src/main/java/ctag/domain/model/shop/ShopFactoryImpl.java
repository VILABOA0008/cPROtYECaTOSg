package ctag.domain.model.shop;

import org.seedstack.business.domain.BaseFactory;

public class ShopFactoryImpl extends BaseFactory<Shop> implements ShopFactory{



  @Override
  public Shop createShop( String nameShop) {
    
    Shop shop=create();
    shop.setIdShop(new ShopId(4));
    shop.setNameShop(nameShop);
    
    return shop;
  }

}
