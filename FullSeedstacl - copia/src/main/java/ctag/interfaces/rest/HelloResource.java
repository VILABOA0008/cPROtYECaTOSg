package ctag.interfaces.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.seedstack.business.assembler.dsl.FluentAssembler;
import org.seedstack.business.domain.Repository;
import org.seedstack.jpa.Jpa;
import org.seedstack.jpa.JpaUnit;
import org.seedstack.seed.transaction.Transactional;

import ctag.domain.model.customer.Customer;
import ctag.domain.model.customer.CustomerId;
import ctag.domain.model.shop.Shop;
import ctag.domain.model.shop.ShopId;
import ctag.interfaces.rest.customer.CustomerRepresentation;
import ctag.interfaces.rest.shop.ShopRepresentation;

@JpaUnit
@Transactional
@Path("hello")
public class HelloResource {

  private Repository<Customer, CustomerId> customerrepository;
  private Repository<Shop, ShopId> shoprepository;
  private FluentAssembler fluenteassembler;

  @Inject
  public HelloResource(@Jpa Repository<Shop, ShopId> shoprepository,
      @Jpa Repository<Customer, CustomerId> customerrepository, FluentAssembler fluenteassembler) {
    this.fluenteassembler = fluenteassembler;
    this.customerrepository = customerrepository;
    this.shoprepository = shoprepository;
  }

  @GET
  public String hello() {

    return "Hello World!\n" + shoprepository.toString() + "  ffff   \n"+ fluenteassembler.toString();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/emp/create")
  public CustomerRepresentation createCustomer(
      final CustomerRepresentation customerRepresentation) {

    Customer c = fluenteassembler.merge(customerRepresentation).into(Customer.class).fromFactory();
    customerrepository.add(c);

    return fluenteassembler.assemble(c).to(CustomerRepresentation.class);
    // return Response.ok().status(200).build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/dept/create")
  public ShopRepresentation createShop(final ShopRepresentation customerRepresentation) {

    Shop c = fluenteassembler.merge(customerRepresentation).into(Shop.class).fromFactory();
    shoprepository.add(c);

    return fluenteassembler.assemble(c).to(ShopRepresentation.class);
    // return Response.ok().status(200).build();
  }
}
