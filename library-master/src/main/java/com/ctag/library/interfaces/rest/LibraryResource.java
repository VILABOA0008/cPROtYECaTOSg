package com.ctag.library.interfaces.rest;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.seedstack.business.assembler.dsl.FluentAssembler;
import org.seedstack.jpa.JpaUnit;
import org.seedstack.seed.Application;

import com.ctag.library.application.utils.LibraryException;
import com.ctag.library.application.utils.LibraryUtils;
import com.ctag.library.domain.model.book.Book;
import com.ctag.library.domain.model.book.BookRepository;
import com.ctag.library.domain.model.customer.Customer;
import com.ctag.library.domain.model.customer.CustomerRepository;
import com.ctag.library.domain.services.ConfigParamsService;
import com.ctag.library.infrastructure.ApplicationConfiguration;
import com.ctag.library.infrastructure.jpa.JpaRepository;
import com.ctag.library.interfaces.rest.book.BookRepresentation;
import com.ctag.library.interfaces.rest.customer.CustomerRepresentation;
import com.google.inject.Inject;

@Path("library")
@JpaUnit
@Transactional
public class LibraryResource {

  public static final String PUSH_BOOK = "/pushbook";
  public static final String CALL_SERVICE = "/getconfig";
  public static final String SUBSCRIBE_CUSTOMER = "/subscribecustomer";
  public static final String UNSUBSCRIBE_CUSTOMER = "/unsubscribecustomer/{dni}";
  public static final String ALL_TABLE = "/all{table}";
  public static final String GET_VALUES = "/get{table}/{column}/{value}";
  public static final String PAYMENT = "payment";
  public static final String RENT_BOOK = "/rentbook/{idbook}/customer/{dni}/{" + PAYMENT + "}";
  public static final String GIVE_BACK_BOOK = "/giveBackBook/{idbook}/customer/{dni}";

  private ApplicationConfiguration myConfig;

  private BookRepository bookRepository;
  private CustomerRepository customerRepository;
  private FluentAssembler fluentAssembler;

  @Inject
  private ConfigParamsService configParamsService;

  @Inject
  LibraryResource(FluentAssembler fluentAssembler, @JpaRepository BookRepository bookRepository,
      @JpaRepository CustomerRepository customerRepository, Application application) {
    this.fluentAssembler = fluentAssembler;
    this.bookRepository = bookRepository;
    this.customerRepository = customerRepository;
    this.myConfig = application.getConfiguration().get(ApplicationConfiguration.class);
  }

  @POST
  @Path(PUSH_BOOK)
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public BookRepresentation createBook(final BookRepresentation bookRepresentation) {
    Book book = fluentAssembler.merge(bookRepresentation).into(Book.class).fromFactory();
    if (book.getQuantity() < 0) {
      throw new InternalServerErrorException(
          LibraryException.ERR_001);
    }
    bookRepository.add(book);
    return fluentAssembler.assemble(book).to(BookRepresentation.class);
  }

  @POST
  @Path(SUBSCRIBE_CUSTOMER)
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public CustomerRepresentation subscribeCustomer(
      final CustomerRepresentation customerRepresentation) {
    Customer customer = fluentAssembler.merge(customerRepresentation).into(Customer.class)
        .fromFactory();
    customerRepository.add(customer);
    return fluentAssembler.assemble(customer).to(CustomerRepresentation.class);
  }

  @GET
  @Path(UNSUBSCRIBE_CUSTOMER)
  @Produces(MediaType.APPLICATION_JSON)
  public void unSubscribeCustomer(@PathParam(Customer.DNI) String dni) {
    LibraryUtils.unSubscribeCustomer(customerRepository, dni);
  }

  @GET
  @Path(ALL_TABLE)
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAll(@PathParam("table") String table) {
    if (table.equals(Book.TABLE_NAME)) {
      return Response.ok(bookRepository.booksList()).build();
    } else if (table.equals(Customer.TABLE_NAME)) {
      return Response.ok(customerRepository.customerList()).build();
    } else {
      throw new InternalServerErrorException(
          LibraryException.ERR_002);
    }
  }

  @GET
  @Path(GET_VALUES)
  @Produces(MediaType.APPLICATION_JSON)
  public Response getCustomerBy(@PathParam("table") String table,
      @PathParam("column") String column, @PathParam("value") String value) {
    if (table.equals(Customer.TABLE_NAME)) {
      return Response.ok(customerRepository.getCustomerBy(column, value)).build();
    } else if (table.equals(Book.TABLE_NAME)) {
      return Response.ok(bookRepository.getBooksBy(column, value)).build();
    } else {
      throw new InternalServerErrorException(
          LibraryException.ERR_002);
    }
  }

  @GET
  @Path(RENT_BOOK)
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public int rentBook(@PathParam(Book.ID_BOOK) String idbook,
      @PathParam(Customer.DNI) String dni, @PathParam(PAYMENT) int payment) {
    return LibraryUtils.customerRentABook(customerRepository, bookRepository,
        myConfig.getMaxBooksForCustomers(), idbook, dni, payment);
  }

  @GET
  @Path(GIVE_BACK_BOOK)
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public void giveBackBook(@PathParam(Book.ID_BOOK) String idbook,
      @PathParam(Customer.DNI) String dni) {
    LibraryUtils.giveBackBook(customerRepository, bookRepository, idbook, dni);
  }

  @GET
  @Path(CALL_SERVICE)
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response getConfig() {
    return Response.ok(configParamsService.maxBooksConfigured(myConfig)).build();
  }

}
