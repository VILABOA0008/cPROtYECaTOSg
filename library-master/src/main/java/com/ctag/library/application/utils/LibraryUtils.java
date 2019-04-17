
package com.ctag.library.application.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.ws.rs.InternalServerErrorException;

import com.ctag.library.domain.model.book.Book;
import com.ctag.library.domain.model.book.BookRepository;
import com.ctag.library.domain.model.customer.Customer;
import com.ctag.library.domain.model.customer.CustomerId;
import com.ctag.library.domain.model.customer.CustomerRepository;
import com.ctag.library.domain.policies.RentPolicy;
import com.google.common.base.Strings;

public class LibraryUtils {

  LibraryUtils() {

  }

  /**
   * Validates the param values if is empty or does not exist.
   * 
   * @param table
   * @param column
   * @param value
   * @throws Exception
   */
  public static void isEmptyParams(String table, String column, String value) {

    if (Strings.isNullOrEmpty(value)) {
      throw new InternalServerErrorException(
          LibraryException.ERR_003);
    }
    if (table.equals(Book.TABLE_NAME)) {
      if (!Arrays.asList(Book.COLUMNS).contains(column)) {
        throw new InternalServerErrorException(
            LibraryException.ERR_004);
      }
    } else if (table.equals(Customer.TABLE_NAME)) {
      if (!Arrays.asList(Customer.COLUMNS).contains(column)) {
        throw new InternalServerErrorException(
            LibraryException.ERR_004);
      }
    } else {
      throw new InternalServerErrorException(
          LibraryException.ERR_002);
    }

  }

  /**
   * Update a customer when he rent a book.
   * 
   * @param customerRepository
   * @param bookRepository
   * @param idbook
   * @param dni
   * @return
   * @throws LibraryException
   */
  public static int customerRentABook(CustomerRepository customerRepository,
      BookRepository bookRepository, int maxBooksForCustomers, String idbook, String dni,
      int payment) {

    List<Customer> customers = customerRepository.getCustomerBy(Customer.DNI, dni);
    Customer customer;
    if (customers.isEmpty()) {
      throw new InternalServerErrorException(
          LibraryException.ERR_005);
    }
    customer = customers.get(0);

    Set<Book> books = customer.getBooks();
    List<Book> lbook = bookRepository.getBooksBy(Book.ID_BOOK, idbook);
    if (lbook.isEmpty()) {
      throw new InternalServerErrorException(
          LibraryException.ERR_006);
    }
    Book book = lbook.get(0);
    if (customer.getBooks().size() >= maxBooksForCustomers) {
      throw new InternalServerErrorException(
          LibraryException.ERR_007);
    }
    if (customer.getBooks().contains(book)) {
      throw new InternalServerErrorException(
          LibraryException.ERR_008);
    }
    if (book.getQuantity() > 0) {
      book.setQuantity(book.getQuantity() - 1);
      books.add(book);
    } else {
      throw new InternalServerErrorException(
          LibraryException.ERR_009);
    }

    payment = RentPolicy.rent(book.getPrice(), customer.getType(), payment);

    customer.setBooks(books);

    return payment;

  }

  public static Customer giveBackBook(CustomerRepository customerRepository,
      BookRepository bookRepository, String idbook, String dni) {

    List<Customer> customers = customerRepository.getCustomerBy(Customer.DNI, dni);
    List<Book> books = bookRepository.getBooksBy(Book.ID_BOOK, idbook);
    Customer customer;
    Book book;

    if (customers.isEmpty()) {
      throw new InternalServerErrorException(
          LibraryException.ERR_005);
    }
    if (books.isEmpty()) {
      throw new InternalServerErrorException(
          LibraryException.ERR_006);
    }

    customer = customers.get(0);
    book = books.get(0);

    if (!customer.getBooks().contains(book)) {
      throw new InternalServerErrorException(
          LibraryException.ERR_010);
    } else {
      customer.getBooks().remove(book);
      book.setQuantity(book.getQuantity() + 1);
    }

    return customer;

  }

  public static void unSubscribeCustomer(CustomerRepository customerRepository, String dni) {

    List<Customer> customers = customerRepository.getCustomerBy(Customer.DNI, dni);
    if (customers.isEmpty()) {
      throw new InternalServerErrorException(
          LibraryException.ERR_005);
    }

    Customer customer = customers.get(0);
    if (!customer.getBooks().isEmpty()) {
      throw new InternalServerErrorException(
          LibraryException.ERR_011);
    } else {
      customerRepository.remove(new CustomerId(customer.getIdCustomer()));
    }

  }

}
