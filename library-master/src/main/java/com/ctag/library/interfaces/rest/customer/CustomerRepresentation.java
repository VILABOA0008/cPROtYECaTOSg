package com.ctag.library.interfaces.rest.customer;

import org.seedstack.business.assembler.AggregateId;
import org.seedstack.business.assembler.FactoryArgument;

import com.ctag.library.domain.model.book.Book;
import com.ctag.library.domain.model.customer.Customer;
import com.ctag.library.interfaces.rest.book.BookRepresentation;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class CustomerRepresentation {

  private int idcustomer;
  private String dni;
  private String name;
  private String type;
  private Set<BookRepresentation> books = new HashSet<>();

  @AggregateId
  @FactoryArgument(index = 0)
  public int getIdCustomer() {
    return idcustomer;
  }

  public void setIdCustomer(int idcustomer) {
    this.idcustomer = idcustomer;
  }

  @FactoryArgument(index = 1)
  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  @FactoryArgument(index = 2)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @FactoryArgument(index = 3)
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @FactoryArgument(index = 4)
  public Set<BookRepresentation> getBooks() {
    return books;
  }

  public void setBooks(Set<BookRepresentation> books) {
    this.books = books;
  }

  @Override
  public boolean equals(final Object other) {
    if (!(other instanceof CustomerRepresentation)) {
      return false;
    }
    CustomerRepresentation castOther = (CustomerRepresentation) other;
    return new EqualsBuilder()
        .append(idcustomer, castOther.getIdCustomer())
        .append(name, castOther.getName())
        .isEquals();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(Customer.ID_CUSTOMER + " : " + idcustomer + ",\n");
    sb.append(Customer.DNI + " : " + dni + ",\n");
    sb.append(Customer.NAME + " : " + name + ",\n");
    sb.append(Customer.TYPE + " : " + type + ",\n");
    sb.append(Book.TABLE_NAME + " : ");
    if (!books.isEmpty()) {
      for (BookRepresentation book : books) {
        sb.append(book.toString());
      }
    } else {
      sb.append("null");
    }
    return sb.toString();
  }

}
