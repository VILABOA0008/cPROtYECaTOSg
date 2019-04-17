package org.videofuture.renter.interfaces.rest.customer;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.seedstack.business.assembler.dsl.FluentAssembler;
import org.seedstack.jpa.Jpa;
import org.seedstack.jpa.JpaUnit;
import org.videofuture.renter.domain.model.customer.Customer;
import org.videofuture.renter.domain.model.customer.CustomerRepository;
import org.videofuture.renter.interfaces.dto.customer.CustomerRepresentation;
import org.videofuture.renter.interfaces.rest.VideoclubRootResource;

import io.swagger.annotations.Api;

@Api
@Transactional
@JpaUnit
@Path(ManageCustomersResource.PATH)
public class ManageCustomersResource {

  public static final String PATH = VideoclubRootResource.PATH + "/customer";
  public static final String LIST_CUSTOMERS = "/list";
  public static final String CREATE_CUSTOMER = "/create";

  @Jpa
  private CustomerRepository customerRepository;
  private FluentAssembler fluentAssembler;

  @Inject
  public ManageCustomersResource(CustomerRepository customerRepository, FluentAssembler fluentAssembler) {
    this.customerRepository = customerRepository;
    this.fluentAssembler = fluentAssembler;
  }

  // create
  
  @POST
  @Path(CREATE_CUSTOMER)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createCustomer(CustomerRepresentation customerRepresentation) {
    Customer customer = fluentAssembler.merge(customerRepresentation).into(Customer.class).fromFactory();
    System.err.println(customer);
    return Response.ok(new Date(new java.util.Date().getTime()).toString()).build();
  }
  
  // read
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path(LIST_CUSTOMERS)
  public Response listCustomers() {
    return Response.ok(customerRepository.listAllCustomers()).build();
  }
  
  // update

  // delete

}
