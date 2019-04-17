package com.ctag.library.domain.model.book;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.seedstack.business.domain.BaseAggregateRoot;

import org.apache.commons.lang3.builder.EqualsBuilder;

@Table(name = Book.TABLE_NAME)
@Entity
@IdClass(BookId.class)
public class Book extends BaseAggregateRoot<BookId> {

  // column names
  public static final String TABLE_NAME = "books";
  public static final String ID_BOOK = "idbook";
  public static final String TITLE = "title";
  public static final String AUTHOR = "author";
  public static final String PRICE = "price";
  public static final String QUANTITY = "quantity";

  public static final String[] COLUMNS = { ID_BOOK, TITLE, AUTHOR, PRICE, QUANTITY };

  // TableGenerator
  @TableGenerator(name = "bookGen", table = "SEQUENCE", pkColumnName = "KeyValue", pkColumnValue = TABLE_NAME, valueColumnName = "Value", allocationSize = 1)

  // variables
  @Id
  @Column(name = ID_BOOK, unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "bookGen")
  private int idbook;

  @Column(name = TITLE, nullable = false)
  private String title;

  @Column(name = AUTHOR, nullable = false)
  private String author;

  @Column(name = PRICE, nullable = false)
  private int price;

  @Column(name = QUANTITY, nullable = false)
  private int quantity;

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(ID_BOOK + " : " + idbook + ",\n");
    sb.append(TITLE + " : " + title + ",\n");
    sb.append(AUTHOR + " : " + author + ",\n");
    sb.append(PRICE + " : " + price + ",\n");
    sb.append(QUANTITY + " : " + quantity + "\n");
    return sb.toString();
  }

  public Book() {
    // Required by Hibernate
  }

  public int getIdBook() {
    return idbook;
  }

  public void setIdBook(BookId idbook) {
    this.idbook = idbook.getBookId();
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int cuantity) {
    this.quantity = cuantity;
  }

  @Override
  public boolean equals(final Object other) {
    if (!(other instanceof Book)) {
      return false;
    }
    Book castOther = (Book) other;
    return new EqualsBuilder()
        .append(idbook, castOther.getIdBook())
        .append(title, castOther.getTitle())
        .append(author, castOther.getAuthor())
        .append(price, castOther.getPrice())
        .append(quantity, castOther.getQuantity())
        .isEquals();
  }

}
