package ctag.interfaces.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.seedstack.business.assembler.dsl.FluentAssembler;
import org.seedstack.jpa.JpaUnit;
import org.seedstack.seed.transaction.Transactional;

import ctag.application.utils.Errors;
import ctag.application.utils.LibraryUtils;
import ctag.domain.model.customer.Customer;
import ctag.domain.model.customer.CustomerRepository;
import ctag.infrastructure.jpa.JpaRepository;
import ctag.interfaces.rest.customer.CustomerRepresentation;

@JpaUnit
@Transactional
@Path("customer")
public class CustomerServices {
  private FluentAssembler fluenteassembler;
  private CustomerRepository customerrepository;

  @Inject
  public CustomerServices(
      @JpaRepository CustomerRepository customerrepository,
      FluentAssembler fluenteassembler) {
    this.customerrepository = customerrepository;
    this.fluenteassembler = fluenteassembler;
  }

  
  @GET
  @Path("/one")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getCustomerByid(@QueryParam("id") int id) {
    return Response.ok(customerrepository.getCustomersById(id)).build();
  }


  @GET
  @Path("/oneSpec")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getCustomerBySpecificationid(@QueryParam("id") int id) {
    return Response.ok(customerrepository.idShops(id)).build();
  }

  @GET
  @Path("/findall")
  @Produces(MediaType.APPLICATION_JSON)
  public Response findByAll(@QueryParam("column") String column,
      @QueryParam("id") String id) {
    if (!LibraryUtils.wrongCustomerAtributtes(column).equalsIgnoreCase(Errors.OK)) {
      throw new InternalServerErrorException(
          Errors.ERR_001);
    }

    return Response.ok(customerrepository.findByAll(column, id)).build();

  }

  @GET
  @Path("/all")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllCustomers() {

    return Response.ok(customerrepository.customerList()).build();
  }
  

  @GET
  @Path("/rich")
  @Produces(MediaType.APPLICATION_JSON)
  public Response richClientes(@QueryParam("cost") int minMoney) {
    return Response.ok(customerrepository.richClientes(minMoney)).build();
  }

  @GET
  @Path("/vips")
  @Produces(MediaType.APPLICATION_JSON)
  public Response vipCustomers(@QueryParam("cost") float minMoney) {
    return Response.ok(customerrepository.vipCustomers(minMoney)).build();
  }
  
  
  
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/create")
  public CustomerRepresentation createCustomer(
      final CustomerRepresentation customerRepresentation) {

    Customer c = fluenteassembler.merge(customerRepresentation).into(Customer.class).fromFactory();
    customerrepository.add(c);

    return fluenteassembler.assemble(c).to(CustomerRepresentation.class);
  }


  @DELETE
  @Path("/delete")
  @Produces(MediaType.APPLICATION_JSON)
  public Response deleteCustomer(@QueryParam("id") int id) {
    return Response.ok(customerrepository.customerDelete(id)).build();
  }

  @PUT
  @Path("/modPrice")
  @Produces(MediaType.APPLICATION_JSON)
  public Response customerModPrice(@QueryParam("id") int id, @QueryParam("money") float money) {
    return Response.ok(customerrepository.customerModMoney(id, money)).build();
  }
  
}
