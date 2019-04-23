package ctag.interfaces.rest.shop;

import org.seedstack.business.assembler.AggregateId;
import org.seedstack.business.assembler.FactoryArgument;

public class ShopRepresentation {
  

  

  private String nameShop;
  

  @FactoryArgument(index=0) 
  public String getNameShop() {
    return nameShop;
  }
  public void setNameShop(String nameShop) {
    this.nameShop = nameShop;
  }



 

}
