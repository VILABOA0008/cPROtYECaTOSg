package org.videofuture.renter.interfaces.dto.renting;

import java.sql.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.seedstack.business.assembler.AggregateId;
import org.seedstack.business.assembler.FactoryArgument;
import org.videofuture.renter.domain.model.renting.Renting;

public class RentingRepresentation {

  private int id;
  private int videoId;
  private int customerId;
  private Date rentingDate;
  private Date returnDate;

  @AggregateId
  public int getId() {
    return id;
  }

  @FactoryArgument(index = 0)
  public int getVideoId() {
    return videoId;
  }

  @FactoryArgument(index = 1)
  public int getCustomerId() {
    return customerId;
  }

  @FactoryArgument(index = 2)
  public Date getRentingDate() {
    return rentingDate;
  }

  public void setRentingDate(Date rentingDate) {
    this.rentingDate = rentingDate;
  }

  @FactoryArgument(index = 3)
  public Date getReturnDate() {
    return returnDate;
  }

  public void setReturnDate(Date returnDate) {
    this.returnDate = returnDate;
  }

  @Override
  public boolean equals(final Object other) {
    if (!(other instanceof RentingRepresentation)) {
      return false;
    }
    RentingRepresentation castOther = (RentingRepresentation) other;
    return new EqualsBuilder()
        .append(id, castOther.getId())
        .append(customerId, castOther.getCustomerId())
        .append(videoId, castOther.getVideoId())
        .append(rentingDate, castOther.getRentingDate())
        .append(returnDate, castOther.getReturnDate())
        .isEquals();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(Renting.RENTING_ID + " : " + id + ",\n");
    sb.append(Renting.CUSTOMER_ID + " : " + customerId + ",\n");
    sb.append(Renting.VIDEO_ID + " : " + videoId + ",\n");
    sb.append(Renting.RENTING_DATE + " : " + rentingDate + ",\n");
    sb.append(Renting.RETURN_DATE + " : " + returnDate + ",\n");
    return sb.toString();
  }
}
