package com.ctag.library.interfaces.rest.book;

import org.seedstack.business.assembler.AggregateId;
import org.seedstack.business.assembler.FactoryArgument;

import com.ctag.library.domain.model.book.Book;
import com.ctag.library.interfaces.rest.customer.CustomerRepresentation;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class BookRepresentation {

  private int idbook;
  private String title;
  private String author;
  private int price;
  private int quantity;
  private Set<CustomerRepresentation> customers = new HashSet<>();

  @AggregateId
  @FactoryArgument(index = 0)
  public int getIdBook() {
    return idbook;
  }

  public void setIdBook(int idbook) {
    this.idbook = idbook;
  }

  @FactoryArgument(index = 1)
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @FactoryArgument(index = 2)
  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  @FactoryArgument(index = 3)
  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  @FactoryArgument(index = 4)
  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @FactoryArgument(index = 5)
  public Set<CustomerRepresentation> getCustomers() {
    return customers;
  }

  public void setCustomers(Set<CustomerRepresentation> customers) {
    this.customers = customers;
  }

  @Override
  public boolean equals(final Object other) {
    if (!(other instanceof BookRepresentation)) {
      return false;
    }
    BookRepresentation castOther = (BookRepresentation) other;
    return new EqualsBuilder()
        .append(idbook, castOther.getIdBook())
        .append(title, castOther.getTitle())
        .append(author, castOther.getAuthor())
        .append(price, castOther.getPrice())
        .append(quantity, castOther.getQuantity())
        .isEquals();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(Book.ID_BOOK + " : " + idbook + ",\n");
    sb.append(Book.TITLE + " : " + title + ",\n");
    sb.append(Book.AUTHOR + " : " + author + ",\n");
    sb.append(Book.PRICE + " : " + price + ",\n");
    sb.append(Book.QUANTITY + " : " + quantity + "\n");
    return sb.toString();
  }

}
