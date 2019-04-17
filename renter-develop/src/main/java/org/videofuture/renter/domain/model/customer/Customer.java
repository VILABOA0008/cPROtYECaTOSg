package org.videofuture.renter.domain.model.customer;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.seedstack.business.domain.BaseAggregateRoot;
import org.seedstack.business.domain.Identity;
import org.seedstack.business.util.inmemory.InMemory;
import org.videofuture.renter.application.utils.SequenceIntGenerator;

@Entity
@Table(name = Customer.TABLE_NAME)
public class Customer extends BaseAggregateRoot<CustomerId> {

  // column names
  public static final String TABLE_NAME = "customers";
  public static final String CUSTOMER_ID = "id";
  public static final String NAME = "name";
  public static final String REGISTER_DATE = "registerDate";

  @Id
  @Identity(generator = SequenceIntGenerator.class)
  @InMemory
  private Integer id;
  @Column(name = NAME, unique = false, nullable = false)
  private String customerName;
  @Column(name = REGISTER_DATE, unique = false, nullable = false)
  private Date registerDate;

  // needed for Hibernate
  public Customer() {

  }

  public Customer(String name, Date registerDate) {
    this.customerName = name;
    this.registerDate = registerDate;
  }

  @Override
  public CustomerId getId() {
    return new CustomerId(id.intValue());
  }

  public String getName() {
    return customerName;
  }

  public void setName(String name) {
    this.customerName = name;
  }

  public Date getRegisterDate() {
    return registerDate;
  }

  public void setRegisterDate(Date registerDate) {
    this.registerDate = registerDate;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(CUSTOMER_ID + " : " + id.intValue() + ",\n");
    sb.append(NAME + " : " + customerName + ",\n");
    sb.append(REGISTER_DATE + " : " + registerDate+ ",\n");
    return sb.toString();
  }
}
