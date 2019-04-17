package org.videofuture.renter.interfaces.dto.customer;

import java.sql.Date;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.seedstack.business.assembler.AggregateId;
import org.seedstack.business.assembler.DtoOf;
import org.seedstack.business.assembler.FactoryArgument;
import org.videofuture.renter.domain.model.customer.Customer;

public class CustomerRepresentation {
  private int id;
  private String name;
  private Date registerDate;
  private List<String> videos;

  @AggregateId
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @FactoryArgument(index = 0)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getRegisterDate() {
    return registerDate;
  }

  public void setRegisterDate(Date registerDate) {
    this.registerDate = registerDate;
  }

  public List<String> getVideos() {
    return Collections.unmodifiableList(videos);
  }

  @Override
  public boolean equals(final Object other) {
    if (!(other instanceof CustomerRepresentation)) {
      return false;
    }
    CustomerRepresentation castOther = (CustomerRepresentation) other;
    return new EqualsBuilder()
        .append(id, castOther.getId())
        .append(name, castOther.getName())
        .append(registerDate, castOther.getRegisterDate())
        .append(videos, castOther.getVideos())
        .isEquals();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(Customer.CUSTOMER_ID + " : " + id + ",\n");
    sb.append(Customer.NAME + " : " + name + ",\n");
    sb.append(Customer.REGISTER_DATE + " : " + registerDate + ",\n");
    sb.append("Number of videos : " + getVideos().size() + ",\n");
    return sb.toString();
  }

}
