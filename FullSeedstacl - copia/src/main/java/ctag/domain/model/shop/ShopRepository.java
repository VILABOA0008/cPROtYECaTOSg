package ctag.domain.model.shop;

import java.util.List;

import org.seedstack.business.domain.Repository; 

public interface ShopRepository extends Repository<Shop,ShopId> {

  List<Shop> shopList();
  
  List<Shop> getShopsBy();
  
}
