package com.ctag.library.domain.model.book;

import java.util.Set;

import org.seedstack.business.domain.Factory;

import com.ctag.library.interfaces.rest.customer.CustomerRepresentation;

public interface BookFactory extends Factory<Book> {

  Book createBook(int idbook, String title, String author, int price, int quantity,
      Set<CustomerRepresentation> customers);

}
