package ctag.domain.model.shop;

import javax.persistence.Embeddable; 

import org.seedstack.business.domain.BaseValueObject;
 
@Embeddable
public class ShopId extends BaseValueObject {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  private int idShop;
  
  ShopId(){
    
  }
  
  public ShopId(int idShop) {
    this.idShop=idShop;
    
  }
  
  public int getShopId() {
    
    return idShop;
  }

}
