package ctag.interfaces.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.seedstack.business.assembler.dsl.FluentAssembler;
import org.seedstack.jpa.JpaUnit;
import org.seedstack.seed.transaction.Transactional;
import ctag.domain.model.customer.Customer;
import ctag.domain.model.customer.CustomerRepository;
import ctag.domain.model.product.Product;
import ctag.domain.model.product.ProductRepository;
import ctag.domain.model.shop.Shop;
import ctag.domain.model.shop.ShopRepository;
import ctag.infrastructure.jpa.JpaRepository;

@JpaUnit
@Transactional
@Path("hello")
public class HelloResource {

  // private Repository<Customer, CustomerId> customerrepository;
  private ShopRepository shoprepository;
  private FluentAssembler fluenteassembler;
  private CustomerRepository customerrepository;
  private ProductRepository productrepository;

  @Inject
  public HelloResource(@JpaRepository ShopRepository shoprepository,
      @JpaRepository CustomerRepository customerrepository,
      @JpaRepository ProductRepository productrepository,
      FluentAssembler fluenteassembler) {
    this.fluenteassembler = fluenteassembler;
    this.customerrepository = customerrepository;
    this.shoprepository = shoprepository;
    this.productrepository = productrepository;

  }

  @GET
  public String hello() {
    System.out.println("sd");
    return "Hello World!";
    // \n" + shoprepository.toString() + " ffff \n"+ fluenteassembler.toString();
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/customer/assign")
  public Shop assignCustomer(@QueryParam("idShop") int idShop,
      @QueryParam("idCustomer") int idCustomer) {
    Customer c = customerrepository.getCustomersById(idCustomer);
    Shop s = shoprepository.getShopsById(idShop);

    s.getCustomer().add(c);

    shoprepository.add(s);

    return s;
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/product/assign")
  public Product assignProduct(@QueryParam("idProduct") int idProduct,
      @QueryParam("idShop") int idShop) {
    Product p = productrepository.getproductById(idProduct);
    Shop s = shoprepository.getShopsById(idShop);
    p.setShop(s);
    productrepository.add(p);

    return p;
  }
  
  
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/product/buy")
  public Response buy(@QueryParam("idCustomer") int idCustomer,@QueryParam("idProduct") int idProduct,@QueryParam("quantity") int quantity){
    Product p = productrepository.getproductById(idProduct);
    Customer c=customerrepository.getCustomersById(idCustomer);
    float total=p.getCost()*quantity;
    if(c.getMoney()<total||p.getQuantity()<1) {    return Response.ok().status(Status.BAD_REQUEST).build();}
    c.setMoney(c.getMoney()-total);
    p.setQuantity(p.getQuantity()-quantity);
return Response.ok(p).build();
  }

}

/*
 * 
 * 
 * @GET
 * 
th>
 * concat("\" ",a,"\",","\" ",b,"\",","\" ",c,"\",","\" ",d,"\",","\" ",f,"\",")
 * String[]customernaemes=
 * {"Lexy"," Nevil"," Sharai"," Elfrieda"," Annamarie","Shep"," Ansell"," Tadd"," Byrom"," Leeland"
 * ,"Lynett"," Inglebert"," Rona"," Arel"," Tamra","Katrinka"," Juliann"," Collete"," Arel"
 * ," Modestine",}; String[]shopnames=
 * {"Keylex"," Wordtune"," Konklux"," Aimbu"," Skaboo","Regrant"," Izio"," Voyatouch"," Oyoba"
 * ," Fivechat","Tin"," Blogpad"," Y-Solowarm"," Photobug"," Innojam","Y-find"," Shufflester"
 * ," Zathin"," Jetwire"," Photobug",}; int c=0; while(c<20) { Random r=new Random();
 * 
 * ProductRepresentation cr=new ProductRepresentation(); cr.setCost((float)
 * (Math.round(12+r.nextFloat()*r.nextInt(70)* 100.0) / 100.0)); cr.setQuantity(3+r.nextInt(20));
 * Product cust = fluenteassembler.merge(cr).into(Product.class).fromFactory();
 * productrepository.add(cust); c++; System.out.println(c); } return Response.ok().build();
 * 
 * }
 */
