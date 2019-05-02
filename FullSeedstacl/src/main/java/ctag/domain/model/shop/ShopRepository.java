package ctag.domain.model.shop;

import java.util.List;

import org.seedstack.business.domain.Repository;

import ctag.domain.model.product.Product;

public interface ShopRepository extends Repository<Shop, ShopId> {

  List<Shop> shopList();

  Shop getShopsById(int id);

  List<Product> prductsListByShop(int id);
  
  boolean shopDelete(int id);

  Shop   shoptModName(String name1, String name2);
}
