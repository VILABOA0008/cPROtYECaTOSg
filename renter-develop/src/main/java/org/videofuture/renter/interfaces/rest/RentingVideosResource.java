package org.videofuture.renter.interfaces.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.seedstack.business.assembler.dsl.FluentAssembler;
import org.seedstack.business.specification.Specification;
import org.seedstack.jpa.JpaUnit;
import org.videofuture.renter.domain.exceptions.RentingException;
import org.videofuture.renter.domain.model.customer.CustomerId;
import org.videofuture.renter.domain.model.renting.Renting;
import org.videofuture.renter.domain.model.renting.RentingId;
import org.videofuture.renter.domain.model.video.Video;
import org.videofuture.renter.domain.model.video.VideoId;
import org.videofuture.renter.domain.model.video.VideoRepository;
import org.videofuture.renter.domain.services.renting.RentingService;
import org.videofuture.renter.interfaces.dto.renting.RentingRepresentation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Renting Videos")
@Transactional
@JpaUnit
@Path(RentingVideosResource.PATH)
public class RentingVideosResource {

  public static final String PATH = VideoclubRootResource.PATH + "/rentings";
  public static final String GET_ALL_RENTINGS = "/list";
  public static final String GET_BY_ID = "/list/{" + Renting.RENTING_ID + "}";
  public static final String CREATE = "/create";
  public static final String DELETE_BY_ID = "/delete/{" + Renting.RENTING_ID + "}";

  private VideoRepository videoRepository;
  private RentingService rentingService;
  private FluentAssembler fluentAssembler;
  
  @Inject
  public RentingVideosResource(FluentAssembler fluentAssembler, VideoRepository videoRepository, RentingService rentingService) {
    this.fluentAssembler = fluentAssembler;
    this.rentingService = rentingService;
  }

  // CRUD
  // create
  @ApiOperation(value = "Creates a new Renting from a rentingRepresentation")
  @POST
  @Path(CREATE)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createRenting(RentingRepresentation rentingRepresentation) {
    StringBuilder responseMessage = new StringBuilder();
    try {
      rentingService.rent(new CustomerId(rentingRepresentation.getCustomerId()),
          new VideoId(rentingRepresentation.getVideoId()));
      return Response.ok().status(201).build();
    } catch (RentingException ex) {
      responseMessage.append(ex.getMessage());
      return Response.ok().status(404, responseMessage.toString()).build();
    }
  }

  // read
  @GET
  @Path(GET_BY_ID)
  @Produces(MediaType.APPLICATION_JSON)
  public Response listById(@PathParam(Renting.RENTING_ID) int rentingId) {
    Specification<Video> matchRentingId = videoRepository.getSpecificationBuilder().of(Video.class)
        .property("rentings.id").equalTo(rentingId).build();
    Video video;
    try {
      video = videoRepository.get(matchRentingId).findFirst().orElseThrow(NoResultException::new);
    } catch (NoResultException ex) {
      return Response.ok(ex.getMessage()).build();
    }
    Renting renting = video.getRentingById(new RentingId(rentingId));
    return Response.ok(renting).build();
  }

  @GET
  @Path(GET_ALL_RENTINGS)
  @Produces(MediaType.APPLICATION_JSON)
  public Response listAllRentings() {
    Specification<Video> allVideos = videoRepository.getSpecificationBuilder().of(Video.class).all()
        .build();
    List<Video> videoList;
    List<Renting> rentingList = new ArrayList<>();
    try {
      videoList = videoRepository.get(allVideos).filter(
          video -> !(video.getRentings().isEmpty())).collect(Collectors.toList());
      videoList.forEach(video -> video.getRentings().forEach(rentingList::add));
    } catch (NoResultException ex) {
      return Response.ok(ex.getMessage()).build();
    }
    return Response.ok(rentingList).build();
  }

  // update

  // delete
  @POST
  @Path(DELETE_BY_ID)
  @Produces(MediaType.APPLICATION_JSON)
  public Response deleteById(@PathParam(Renting.RENTING_ID) int rentingId) {
    // TODO delete by id
    return null;
  }
}
