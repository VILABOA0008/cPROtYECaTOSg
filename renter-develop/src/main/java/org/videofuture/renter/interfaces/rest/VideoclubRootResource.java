package org.videofuture.renter.interfaces.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Videoclub")
@Path(VideoclubRootResource.PATH)
public class VideoclubRootResource {

  public static final String PATH = "videoclub";

  @ApiOperation(value = "Eh que tal hola", notes = "esto hace tal cosa", response = Integer.class, responseContainer = "ArrayList")
  @GET
  @Produces(MediaType.TEXT_HTML)
  public String hello() {
    return "<div style='width:100%; height:100%; display:flex'><div style='margin:auto auto'><h1 style='font-size:5rem'>Video rent service<h1><br/>"
        + "<h4>In order to make operations under our application please make use of the following url resources:</h4>"
        + "<ul>"
        + "<li>/videoclub - Takes you to the homepage</li>"
        + "<li>/videoclub/listVideos - Lists all available videos for renting</li>"
        + "<li>/videoclub/listCustomers - Lists all registered clients</li>"
        + "<li>/videoclub/listRentings - Lists all registered rentings</li>"
        + "<li>/videoclub/rent/{idCustomer}/{idVideo} - To rent a video, use a customerId, followed by the videoId</li>"
        + "</ul></div></div>";
  }
}
