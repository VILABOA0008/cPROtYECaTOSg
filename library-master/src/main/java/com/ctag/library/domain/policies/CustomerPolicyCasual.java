package com.ctag.library.domain.policies;

import javax.inject.Named;
import javax.ws.rs.InternalServerErrorException;

import com.ctag.library.application.utils.LibraryException;

@Named("casual")
public class CustomerPolicyCasual implements CustomerPolicy {

  @Override
  public int rentBook(int bookPrice, int payment) {

    int moneyBack;
    if (payment >= bookPrice) {
      moneyBack = payment - bookPrice;
    } else {
      throw new InternalServerErrorException(
          LibraryException.ERR_013);
    }
    return moneyBack;
  }

}
