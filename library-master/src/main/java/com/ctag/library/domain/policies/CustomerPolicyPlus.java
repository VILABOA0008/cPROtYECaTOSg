package com.ctag.library.domain.policies;

import javax.inject.Named;
import javax.ws.rs.InternalServerErrorException;

import com.ctag.library.application.utils.LibraryException;

@Named("plus")
public class CustomerPolicyPlus implements CustomerPolicy {

  @Override
  public int rentBook(int bookPrice, int payment) {

    int moneyBack;
    int plusPrice = (bookPrice / 2);
    if (payment >= plusPrice) {
      moneyBack = payment - plusPrice;
    } else {
      throw new InternalServerErrorException(
          LibraryException.ERR_013);
    }
    return moneyBack;
  }

}
