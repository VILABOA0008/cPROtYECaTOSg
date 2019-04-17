package com.ctag.library.domain.services;

import com.ctag.library.infrastructure.ApplicationConfiguration;

public class ConfigParamsServiceImpl implements ConfigParamsService {

  @Override
  public int maxBooksConfigured(ApplicationConfiguration myConfig) {
    return myConfig.getMaxBooksForCustomers();
  }

}
