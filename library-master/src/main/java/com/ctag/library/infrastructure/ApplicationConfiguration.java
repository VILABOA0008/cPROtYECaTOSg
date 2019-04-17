package com.ctag.library.infrastructure;

import org.seedstack.coffig.Config;

@Config("config")
public class ApplicationConfiguration {

  private int maxBooksForCustomers;

  public int getMaxBooksForCustomers() {
    return maxBooksForCustomers;
  }

}
