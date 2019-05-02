package ctag.domain.model.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.seedstack.business.domain.BaseAggregateRoot;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ctag.domain.model.shop.Shop;

@Entity
@Table(name="Product")
@IdClass(ProductId.class)
public class Product extends BaseAggregateRoot<ProductId> {

@TableGenerator(name="ProductGen", table="SEQUENCE",pkColumnValue = "Product",allocationSize = 1 )
@Id
@Column(name="idProduct",unique=true,nullable = false)
@GeneratedValue(strategy =GenerationType.AUTO, generator = "ProductGen")
  private int idProduct;
  
@JsonIgnore
@ManyToOne
@JoinColumn(name="shop")
private Shop shop;

  
  @Column(name="cost",nullable = false)
  private float cost;
  
  
  @Column(name="quantity",nullable = false)
  private int quantity;


  public int getIdProduct() {
    return idProduct;
  }


  public void setIdProduct(int idProduct) {
    this.idProduct = idProduct;
  }


  public float getCost() {
    return cost;
  }


  public void setCost(float cost) {
    this.cost = cost;
  }


  public int getQuantity() {
    return quantity;
  }


  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Product other = (Product) obj;
    return Float.floatToIntBits(cost) == Float.floatToIntBits(other.cost)
        && idProduct == other.idProduct && quantity == other.quantity;
  }


  public Shop getShop() {
    return shop;
  }


  public void setShop(Shop shop) {
    this.shop = shop;
  }


  @Override
  public String toString() {
    return "Product [idProduct=" + idProduct + ", cost=" + cost + ", quantity=" + quantity + "]";
  }
  
  
  
}

