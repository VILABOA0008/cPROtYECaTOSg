package com.ctag.library.interfaces.rest.customer;

import org.seedstack.business.assembler.BaseAssembler;

import com.ctag.library.domain.model.customer.Customer;
import com.ctag.library.domain.model.customer.CustomerId;
import com.ctag.library.interfaces.rest.customer.CustomerRepresentation;

public class CustomerAssembler extends BaseAssembler<Customer, CustomerRepresentation> {

  @Override
  public void mergeAggregateIntoDto(Customer sourceAggregate, CustomerRepresentation targetDto) {
    targetDto.setIdCustomer(sourceAggregate.getIdCustomer());
    targetDto.setDni(sourceAggregate.getDni());
    targetDto.setName(sourceAggregate.getName());
    targetDto.setType(sourceAggregate.getType());
  }

  @Override
  public void mergeDtoIntoAggregate(CustomerRepresentation sourceDto, Customer targetAggregate) {
    targetAggregate.setIdCustomer(new CustomerId(sourceDto.getIdCustomer()));
    targetAggregate.setDni(sourceDto.getDni());
    targetAggregate.setName(sourceDto.getName());
    targetAggregate.setType(sourceDto.getType());
  }

}
