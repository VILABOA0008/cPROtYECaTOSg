package org.videofuture.renter.application.utils;

import java.util.concurrent.atomic.AtomicInteger;

import org.seedstack.business.domain.Entity;
import org.seedstack.business.util.inmemory.InMemory;

@InMemory
public class InMemorySequenceIntGenerator implements SequenceIntGenerator {
  
  private static final AtomicInteger sequence = new AtomicInteger();
  
  @Override
  public <E extends Entity<Integer>> Integer generate(Class<E> entityClass) {
    return sequence.incrementAndGet();
  }

}
