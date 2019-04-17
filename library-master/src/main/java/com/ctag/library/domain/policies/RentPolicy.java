package com.ctag.library.domain.policies;

import javax.ws.rs.InternalServerErrorException;

import com.ctag.library.application.utils.LibraryException;
import com.ctag.library.domain.model.customer.Customer;

public class RentPolicy {

  public static int rent(int bookPrice, String customerType, int payment) {

    if (customerType.equals(Customer.TYPE_PLUS) || customerType.equals(Customer.TYPE_CASUAL)) {

      switch (customerType) {
      case Customer.TYPE_CASUAL:
        payment = new CustomerPolicyCasual().rentBook(bookPrice, payment);
        break;
      case Customer.TYPE_PLUS:
        payment = new CustomerPolicyPlus().rentBook(bookPrice, payment);
        break;
      default:
        payment = new CustomerPolicyCasual().rentBook(bookPrice, payment);
        break;
      }
      return payment;
    } else {
      throw new InternalServerErrorException(
          LibraryException.ERR_014);
    }

  }

}
