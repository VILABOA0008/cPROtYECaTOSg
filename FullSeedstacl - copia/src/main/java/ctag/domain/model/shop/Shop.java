package ctag.domain.model.shop;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import org.seedstack.business.domain.BaseAggregateRoot;


@Table(name="Shop")
@Entity
@IdClass(ShopId.class)
public class Shop  extends BaseAggregateRoot<ShopId>{

  @TableGenerator(name="shopGen", table = "IDENTITY",pkColumnName = "KeyValue",pkColumnValue = "Shop",allocationSize = 1)
  @Id
  @Column(name = "idShop", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "shopGen")
  private int idShop;
  
  @Column(name="nameShop",nullable=false)
  private String nameShop;

  public Shop() {}
  
  public int getIdShop() {
    return idShop;
  }

  public void setIdShop(ShopId shopId) {
    this.idShop = shopId.getShopId();
  }

  public String getNameShop() {
    return nameShop;
  }

  public void setNameShop(String nameShop) {
    this.nameShop = nameShop;
  }
  
  
  
  
  
  
  
  
}



