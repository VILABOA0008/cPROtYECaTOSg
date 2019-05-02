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

import ctag.domain.model.shop.Shop;
import ctag.domain.model.shop.ShopRepository;
import ctag.infrastructure.jpa.JpaRepository;
import ctag.interfaces.rest.shop.ShopRepresentation;


  @JpaUnit
  @Transactional
  @Path("shop")
  public class ShopServices {
    private FluentAssembler fluenteassembler;
    private ShopRepository shoprepository;

    @Inject
    public ShopServices(
        @JpaRepository ShopRepository shoprepository,
        FluentAssembler fluenteassembler) {
      this.shoprepository = shoprepository;
      this.fluenteassembler=fluenteassembler;
    }
   
    

    @Path("/listAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllShops() {

      return Response.ok(shoprepository.shopList()).build();
    }
    
    @GET
    @Path("/findById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShopByid(@QueryParam("id") int id) {
      return Response.ok(shoprepository.getShopsById(id)).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/create")
    public ShopRepresentation createShop(
        final ShopRepresentation shopRepresentation) {

      Shop c = fluenteassembler.merge(shopRepresentation).into(Shop.class).fromFactory();
      shoprepository.add(c);

      return fluenteassembler.assemble(c).to(ShopRepresentation.class);
    }
    
    @PUT
    @Path("/modName")
    @Produces(MediaType.APPLICATION_JSON)
    public Response productModPrice(@QueryParam("name1") String name1, @QueryParam("name2") String name2) {
      return Response.ok(shoprepository.shoptModName(name1, name2)).build();
    }
    
    @DELETE
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteShop(@QueryParam("id") int id) {
      return Response.ok(shoprepository.shopDelete(id)).build();
    }
    
    @GET
    @Path("/productslist")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListProducts(@QueryParam("id") int id) {
      return Response.ok(shoprepository.prductsListByShop(id)).build();
    }
    
    @GET
    @Path("/modName")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getExpensiveProducts(@QueryParam("price") String name1, @QueryParam("name2") String name2) {
      return Response.ok(shoprepository.shoptModName(name1, name2)).build();
    }
    
    
  }