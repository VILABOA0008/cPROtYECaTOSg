package org.videofuture.renter.domain.model.video;

import javax.persistence.Embeddable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.seedstack.business.domain.BaseValueObject;

@Embeddable
public class VideoId extends BaseValueObject {
  /**
   * 
   */
  private static final long serialVersionUID = -5743885996107234590L;

  private Integer value;

  // needed for Hibernate
  public VideoId() {
  }
  
  public VideoId(int id) {
    this.value = id;
  }

  public Integer getValue() {
    return value;
  }

  @Override
  public boolean equals(final Object obj) {
    if (!(obj instanceof VideoId)) {
      return false;
    }
    final VideoId castOther = (VideoId) obj;
    return new EqualsBuilder().append(value, castOther.getValue()).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 31).append(value).toHashCode();
  }
}
