package com.ctag.library.domain.model.customer;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.seedstack.business.domain.BaseAggregateRoot;

import com.ctag.library.domain.model.book.Book;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Table(name = Customer.TABLE_NAME)
@Entity
@IdClass(CustomerId.class)
public class Customer extends BaseAggregateRoot<CustomerId> {

  // column names
  public static final String TABLE_NAME = "customers";
  public static final String ID_CUSTOMER = "idcustomer";
  public static final String DNI = "dni";
  public static final String NAME = "name";
  public static final String TYPE = "type";

  public static final String TYPE_CASUAL = "casual";
  public static final String TYPE_PLUS = "plus";

  public static final String[] COLUMNS = { ID_CUSTOMER, DNI, NAME, TYPE };

  // TableGenerator
  @TableGenerator(name = "customerGen", table = "SEQUENCE", pkColumnName = "KeyValue", pkColumnValue = TABLE_NAME, valueColumnName = "Value", allocationSize = 1)

  // variables
  @Id
  @Column(name = ID_CUSTOMER, unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "customerGen")
  private int idcustomer;

  @Column(name = DNI, nullable = false)
  private String dni;

  @Column(name = NAME, nullable = false)
  private String name;

  @Column(name = TYPE, nullable = false)
  private String type;

  @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
  @JoinTable(name = "books_has_customers", joinColumns = {
      @JoinColumn(name = ID_CUSTOMER) }, inverseJoinColumns = { @JoinColumn(name = Book.ID_BOOK) })
  Set<Book> books = new HashSet<>();

  public Customer() {
    // Required by Hibernate
  }

  public int getIdCustomer() {
    return idcustomer;
  }

  public void setIdCustomer(CustomerId idcustomer) {
    this.idcustomer = idcustomer.getCustomerId();
  }

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Set<Book> getBooks() {
    return books;
  }

  public void setBooks(Set<Book> books) {
    this.books = books;
  }

  @Override
  public boolean equals(final Object other) {
    if (!(other instanceof Customer)) {
      return false;
    }
    Customer castOther = (Customer) other;
    return new EqualsBuilder()
        .append(idcustomer, castOther.getIdCustomer())
        .append(dni, castOther.getDni())
        .append(name, castOther.getName())
        .isEquals();
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append(ID_CUSTOMER, idcustomer)
        .append(DNI, dni)
        .append(NAME, name)
        .append(TYPE, type)
        .toString();
  }

}
