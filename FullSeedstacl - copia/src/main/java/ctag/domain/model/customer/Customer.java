package ctag.domain.model.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.seedstack.business.domain.BaseAggregateRoot;

@Table(name = "Customer")
@Entity
@IdClass(CustomerId.class)
public class Customer extends BaseAggregateRoot<CustomerId> {

  @TableGenerator(name = "CustomerGen", table = "SEQUENCE", pkColumnName = "Customer", pkColumnValue = "Shop", allocationSize = 1)
  @Id
  @Column(name = "idCustomer", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "CustomerGen")
  private int idCustomer;

  @Column(name = "name", nullable = false)
  private String name;

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

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

}
