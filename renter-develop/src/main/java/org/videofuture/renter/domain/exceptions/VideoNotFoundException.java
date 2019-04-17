package org.videofuture.renter.domain.exceptions;

public class VideoNotFoundException extends RentingException {

  /**
   * 
   */
  private static final long serialVersionUID = 5352404844241180812L;
  
  public VideoNotFoundException() {
    super("Specified video was not found on database");
  }
}
