package ctag.domain.model.customer;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.seedstack.business.domain.BaseAggregateRoot;

import ctag.domain.model.shop.Shop;

@Table(name = "Customer")
@Entity
@IdClass(CustomerId.class)
public class Customer extends BaseAggregateRoot<CustomerId> {

  @TableGenerator(name = "CustomerGen", table = "SEQUENCE", pkColumnValue = "Customer", allocationSize = 1)
  @Id
  @Column(name = "idCustomer", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "CustomerGen")
  private int idCustomer;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "money", nullable = false)
  private float money;

  @ManyToMany(mappedBy = "customer", fetch = FetchType.EAGER)
  private Set<Shop> shop = new HashSet<>();

  @Column(name = "age", nullable = false)
  private int age;

  public Customer() {

  }

  public int getIdCustomer() {
    return idCustomer;
  }

  public void setIdCustomer(CustomerId id) {
    this.idCustomer = id.getCustomerId();
  }

  public String getName() {
    return name;
  }

  public Set<Shop> getShop() {
    return shop;
  }

  public void setShop(Set<Shop> shop) {
    this.shop = shop;
  }

  public void setIdCustomer(int idCustomer) {
    this.idCustomer = idCustomer;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public float getMoney() {
    return money;
  }

  public void setMoney(float money) {
    this.money = money;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    Customer other = (Customer) obj;
    return age == other.age && idCustomer == other.idCustomer && Objects.equals(name, other.name)
        && Objects.equals(shop, other.shop);
  }

  @Override
  public String toString() {
    return "Customer [idCustomer=" + idCustomer + ", name=" + name + ", shop=, age="
        + age + "]";
  }

}
