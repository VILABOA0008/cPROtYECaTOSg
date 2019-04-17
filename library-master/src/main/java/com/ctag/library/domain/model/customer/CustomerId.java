package com.ctag.library.domain.model.customer;

import javax.persistence.Embeddable;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;

import org.seedstack.business.domain.BaseValueObject;

@Embeddable
public class CustomerId extends BaseValueObject {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private int idcustomer;

  /**
   * Required by Hibernate
   */
  CustomerId() {
  }

  public CustomerId(int id) {
    this.idcustomer = id;
  }

  public int getCustomerId() {
    return idcustomer;
  }

  @Override
  public boolean equals(final Object obj) {
    if (!(obj instanceof CustomerId)) {
      return false;
    }
    final CustomerId castOther = (CustomerId) obj;
    return new EqualsBuilder().append(idcustomer, castOther.getCustomerId()).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 31).append(idcustomer).toHashCode();
  }

}
