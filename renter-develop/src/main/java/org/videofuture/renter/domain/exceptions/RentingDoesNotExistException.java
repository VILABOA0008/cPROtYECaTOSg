package org.videofuture.renter.domain.exceptions;

public class RentingDoesNotExistException extends RentingException {
  /**
   * 
   */
  private static final long serialVersionUID = 6209617590836902045L;

  public RentingDoesNotExistException() {
    super("Specified renting does not exist on database");
  }
}
