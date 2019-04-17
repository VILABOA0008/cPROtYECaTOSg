package com.ctag.library.domain.model.book;

import javax.persistence.Embeddable;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;

import org.seedstack.business.domain.BaseValueObject;

@Embeddable
public class BookId extends BaseValueObject {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private int idbook;

  /**
   * Required by Hibernate
   */
  BookId() {
  }

  public BookId(int idbook) {
    this.idbook = idbook;
  }

  public int getBookId() {
    return idbook;
  }

  @Override
  public boolean equals(final Object obj) {
    if (!(obj instanceof BookId)) {
      return false;
    }
    final BookId castOther = (BookId) obj;
    return new EqualsBuilder().append(idbook, castOther.getBookId()).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 31).append(idbook).toHashCode();
  }

}
