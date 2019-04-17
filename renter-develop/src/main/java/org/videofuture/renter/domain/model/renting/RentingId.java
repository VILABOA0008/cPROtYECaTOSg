package org.videofuture.renter.domain.model.renting;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.seedstack.business.domain.BaseValueObject;
import org.seedstack.business.domain.Identity;
import org.seedstack.business.util.SequenceGenerator;
import org.seedstack.business.util.inmemory.InMemory;

@Embeddable
public class RentingId extends BaseValueObject {
  /**
   *  
   */
  private static final long serialVersionUID = 4769880962140129852L;
  
  @Column(name = Renting.RENTING_ID, unique = true, nullable = false, insertable = false, updatable = false)
  private Integer value;

  // needed for Hibernate
  public RentingId() {
  }

  public RentingId(int id) {
    this.value = id;
  }

  public Integer getValue() {
    return value;
  }

  @Override
  public boolean equals(final Object obj) {
    if (!(obj instanceof RentingId)) {
      return false;
    }
    final RentingId castOther = (RentingId) obj;
    return new EqualsBuilder().append(value, castOther.getValue()).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 31).append(value).toHashCode();
  }
}
