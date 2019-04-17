package com.ctag.library.domain.model.customer;

import java.util.Set;

import org.seedstack.business.domain.Factory;

import com.ctag.library.domain.model.book.Book;

public interface CustomerFactory extends Factory<Customer> {

  Customer createCustomer(int idCustomer, String dni, String name, String type, Set<Book> books);

}
