package ctag.domain.model.shop;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import org.seedstack.business.domain.BaseAggregateRoot;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ctag.domain.model.customer.Customer;
import ctag.domain.model.product.Product;

@Table(name = "Shop")
@Entity
@IdClass(ShopId.class)
public class Shop extends BaseAggregateRoot<ShopId> {

  @TableGenerator(name = "shopGen", table = "SEQUENCE", pkColumnValue = "Shop", allocationSize = 1)
  @Id
  @Column(name = "idShop", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "shopGen")
  private int idShop;

  @Column(name = "nameShop", nullable = false)
  private String nameShop;

  @JsonIgnore
  @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
  @JoinTable(name = "shop_customer", joinColumns = {
      @JoinColumn(name = "shop") }, inverseJoinColumns = { @JoinColumn(name = "customer") })
  private Set<Customer> customer = new HashSet<>();

  //@JsonIgnore
  @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private Set<Product> products = new HashSet<>();
  
  public Shop() {
  }

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

  public Set<Customer> getCustomer() {
    return customer;
  }

  public void setCustomer(Set<Customer> customer) {
    this.customer = customer;
  }

  public void setIdShop(int idShop) {
    this.idShop = idShop;
  }

  @Override
  public String toString() {
    return "Shop [idShop=" + idShop + ", nameShop=" + nameShop + ", customer=" + customer + "]";
  }

  
  
  public Set<Product> getProducts() {
    return products;
  }

  public void setProducts(Set<Product> products) {
    this.products = products;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + Objects.hash(customer, idShop, nameShop);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    Shop other = (Shop) obj;
    return Objects.equals(customer, other.customer) && idShop == other.idShop
        && Objects.equals(nameShop, other.nameShop);
  }

}
