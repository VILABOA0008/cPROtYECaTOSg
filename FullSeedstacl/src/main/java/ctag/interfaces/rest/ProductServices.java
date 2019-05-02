package ctag.interfaces.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
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

import ctag.domain.model.product.Product;
import ctag.domain.model.product.ProductRepository;
import ctag.infrastructure.jpa.JpaRepository;
import ctag.interfaces.rest.product.ProductRepresentation;


  @JpaUnit
  @Transactional
  @Path("product")
  public class ProductServices {
    private FluentAssembler fluenteassembler;
    private ProductRepository productrepository;

    @Inject
    public ProductServices(
        @JpaRepository ProductRepository productrepository,
        FluentAssembler fluenteassembler) {
      this.productrepository = productrepository;
      this.fluenteassembler=fluenteassembler;
    }
    
    @GET
    public String hello() {
      return "Hello World!";
    }

    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProducts() {

      return Response.ok(productrepository.productList()).build();
    }
    
    @GET
    @Path("/findOne")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductbyId(@QueryParam("id") int id) {
      return Response.ok(productrepository.getproductById(id)).build();
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/create")
    public ProductRepresentation createProduct(
        final ProductRepresentation productRepresentation) {

      Product c = fluenteassembler.merge(productRepresentation).into(Product.class).fromFactory();
      productrepository.add(c);

      return fluenteassembler.assemble(c).to(ProductRepresentation.class);
    }

    
    @DELETE
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteProduct(@QueryParam("id") int id) {
      return Response.ok(productrepository.productDelete(id)).build();
    }
    

    @PUT
    @Path("/modPrice")
    @Produces(MediaType.APPLICATION_JSON)
    public Response productModPrice(@QueryParam("id") int id, @QueryParam("price") float price) {
      return Response.ok(productrepository.productModPrice(id, price)).build();
    }
    
    @GET
    @Path("/expensive")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getexpensiveProducts(@QueryParam("price") int price) {
      return Response.ok(productrepository.expensiveProducts(price)).build();
    }
    
}
