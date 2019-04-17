package com.ctag.library.domain.model.book;

import java.util.Set;

import org.seedstack.business.domain.BaseFactory;

import com.ctag.library.interfaces.rest.customer.CustomerRepresentation;

public class BookFactoryImpl extends BaseFactory<Book> implements BookFactory {

  @Override
  public Book createBook(int idbook, String title, String author, int price, int quantity,
      Set<CustomerRepresentation> customers) {
    Book book = create();
    book.setIdBook(new BookId(idbook));
    book.setTitle(title);
    book.setAuthor(author);
    book.setPrice(price);
    book.setQuantity(quantity);
    return book;
  }

}
