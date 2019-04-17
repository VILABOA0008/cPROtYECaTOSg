package com.ctag.library.domain.services;

import org.seedstack.business.Service;

import com.ctag.library.infrastructure.ApplicationConfiguration;

@Service
public interface ConfigParamsService {

  int maxBooksConfigured(ApplicationConfiguration myConfig);

}
