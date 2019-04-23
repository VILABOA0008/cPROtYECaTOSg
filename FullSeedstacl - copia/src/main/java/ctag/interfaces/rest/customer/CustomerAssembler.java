package ctag.interfaces.rest.customer;

import org.seedstack.business.assembler.BaseAssembler;

import ctag.domain.model.customer.Customer;
import ctag.domain.model.customer.CustomerId;

public class CustomerAssembler extends BaseAssembler<Customer , CustomerRepresentation> {

  @Override
  public void mergeAggregateIntoDto(Customer sourceAggregate, CustomerRepresentation targetDto) {
  //targetDto.setIdcustomer(sourceAggregate.getIdCustomer());
  targetDto.setName(sourceAggregate.getName());
  targetDto.setAge(sourceAggregate.getAge());

    
  }

  @Override
  public void mergeDtoIntoAggregate(CustomerRepresentation sourceDto, Customer targetAggregate) {

    targetAggregate.setName(sourceDto.getName());
    targetAggregate.setAge(sourceDto.getAge());
    
  }

}
