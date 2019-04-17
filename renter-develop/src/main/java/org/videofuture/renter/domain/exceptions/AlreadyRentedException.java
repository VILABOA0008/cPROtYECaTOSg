package org.videofuture.renter.domain.exceptions;

public class AlreadyRentedException extends RentingException {

  /**
   * 
   */
  private static final long serialVersionUID = -5799275536893979067L;

  
  public AlreadyRentedException() {
    super("Specified video is already rented");
  }
}
