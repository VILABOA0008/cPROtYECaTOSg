package ctag.interfaces.rest.product;

import org.seedstack.business.assembler.FactoryArgument;

import ctag.domain.model.shop.Shop;

public class ProductRepresentation {

  private float cost;
  private int quantity;
  Shop shop;
  
  @FactoryArgument(index=0)
  public float getCost() {
    return cost;
  }
  public void setCost(float cost) {
    this.cost = cost;
  }
  @FactoryArgument(index=1)
  public int getQuantity() {
    return quantity;
  }
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
  @FactoryArgument(index=2)
  public Shop getShop() {
    return shop;
  }
  public void setShop(Shop shop) {
    this.shop = shop;
  }
  
  
  
  
}
