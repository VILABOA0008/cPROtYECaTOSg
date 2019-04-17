package com.ctag.library.domain.policies;

import org.seedstack.business.domain.DomainPolicy;

@DomainPolicy
public interface CustomerPolicy {

  public int rentBook(int bookPrice, int payment);

}
