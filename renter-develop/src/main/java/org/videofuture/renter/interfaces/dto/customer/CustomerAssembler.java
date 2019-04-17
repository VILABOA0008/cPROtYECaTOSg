package org.videofuture.renter.interfaces.dto.customer;

import org.seedstack.business.assembler.BaseAssembler;
import org.videofuture.renter.domain.model.customer.Customer;

public class CustomerAssembler extends BaseAssembler<Customer, CustomerRepresentation> {

  @Override
  public void mergeAggregateIntoDto(Customer sourceAggregate, CustomerRepresentation targetDto) {
    targetDto.setId(sourceAggregate.getId().getValue());
    targetDto.setName(sourceAggregate.getName());
    targetDto.setRegisterDate(sourceAggregate.getRegisterDate());
  }

  @Override
  public void mergeDtoIntoAggregate(CustomerRepresentation sourceDto, Customer targetAggregate) {
    targetAggregate.setName(sourceDto.getName());
    targetAggregate.setRegisterDate(sourceDto.getRegisterDate());
  }
}
