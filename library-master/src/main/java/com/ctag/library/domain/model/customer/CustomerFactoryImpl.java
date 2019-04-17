package com.ctag.library.domain.model.customer;

import java.util.Set;

import javax.ws.rs.InternalServerErrorException;

import org.seedstack.business.domain.BaseFactory;

import com.ctag.library.application.utils.LibraryException;
import com.ctag.library.domain.model.book.Book;

public class CustomerFactoryImpl extends BaseFactory<Customer> implements CustomerFactory {

  @Override
  public Customer createCustomer(int idCustomer, String dni, String name, String type,
      Set<Book> books) {
    if (dni.length() != 9) {
      throw new InternalServerErrorException(
          LibraryException.ERR_012);
    }
    if (type.equals(Customer.TYPE_PLUS) || type.equals(Customer.TYPE_CASUAL)) {
      Customer customer = create();
      customer.setIdCustomer(new CustomerId(idCustomer));
      customer.setDni(dni);
      customer.setName(name);
      customer.setType(type);
      return customer;
    } else {
      throw new InternalServerErrorException(
          LibraryException.ERR_014);
    }
  }

}
