package org.videofuture.renter.domain.exceptions;

public class CustomerNotFoundException extends RentingException {

  /**
   * 
   */
  private static final long serialVersionUID = 3304616674588860200L;

 public CustomerNotFoundException() {
   super("Specified customer could not be found on database");
 }
}
