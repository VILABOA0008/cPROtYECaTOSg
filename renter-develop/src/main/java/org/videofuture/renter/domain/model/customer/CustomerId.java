package org.videofuture.renter.domain.model.customer;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.seedstack.business.domain.BaseValueObject;

@Embeddable
public class CustomerId extends BaseValueObject {
  /**
  * 
  */
  private static final long serialVersionUID = 3883796239572898901L;

  @Column(name = Customer.CUSTOMER_ID, unique = true, nullable = false, insertable = false, updatable = false)
  private int value;

  // needed for Hibernate
  public CustomerId() {
  }

  public CustomerId(int id) {
    this.value = id;
  }

  public int getValue() {
    return value;
  }

  @Override
  public boolean equals(final Object obj) {
    if (!(obj instanceof CustomerId)) {
      return false;
    }
    final CustomerId castOther = (CustomerId) obj;
    return new EqualsBuilder().append(value, castOther.getValue()).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 31).append(value).toHashCode();
  }

}
