package org.videofuture.renter.interfaces.rest.video;

import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.seedstack.business.assembler.Assembler;
import org.seedstack.business.assembler.dsl.FluentAssembler;
import org.seedstack.jpa.Jpa;
import org.seedstack.jpa.JpaUnit;
import org.videofuture.renter.domain.model.video.Video;
import org.videofuture.renter.domain.model.video.VideoFactory;
import org.videofuture.renter.domain.model.video.VideoRepository;
import org.videofuture.renter.interfaces.dto.video.VideoRepresentation;
import org.videofuture.renter.interfaces.rest.VideoclubRootResource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Video Management")
@Transactional
@JpaUnit
@Path(ManageVideosResource.PATH)
public class ManageVideosResource {

  public static final String PATH = VideoclubRootResource.PATH + "/videos";
  public static final String LIST_VIDEOS = "list";
  public static final String LIST_VIDEO = "list/{" + Video.VIDEO_ID + "}";
  public static final String CREATE_VIDEO = "create";

  
  // private Repository<Video, VideoId> videoRepository;
  @Jpa
  private VideoRepository videoRepository;
  private VideoFactory videoFactory;
  private FluentAssembler fluentAssembler;
  private Assembler<Video, VideoRepresentation> videoAssembler;

  @Inject
  public ManageVideosResource(VideoRepository videoRepository, VideoFactory videoFactory,
      FluentAssembler fluentAssembler, Assembler<Video, VideoRepresentation> videoAssembler) {
    this.videoRepository = videoRepository;
    this.videoFactory = videoFactory;
    this.fluentAssembler = fluentAssembler;
    this.videoAssembler = videoAssembler;
  }

  // create
  @ApiOperation(value = "Creates a new Video from parameters", notes = "The following parameters must apply: A Dto VideoRepresentation object")
  @POST
  @Path(CREATE_VIDEO)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createVideo(VideoRepresentation videoRepresentation) {
    Video video = fluentAssembler.merge(videoRepresentation).into(Video.class).fromFactory();
    System.err.println(video);
    //videoRepository.add(video);
    System.err.println(video);
    return Response.ok(video.toString() + ", " + video.getId().toString())
        .build();
  }

  // read
  @ApiOperation(value = "Retrieves a video with a matching id in database", response = VideoRepresentation.class)
  @GET
  @Path(LIST_VIDEO)
  @Produces(MediaType.APPLICATION_JSON)
  public Response getVideoById(@PathParam(Video.VIDEO_ID) int videoId) {
    Optional<Video> requestedVideo = videoRepository.getById(videoId);
    if (requestedVideo.isPresent())
      return Response.ok(fluentAssembler.assemble(requestedVideo.get()).to(VideoRepresentation.class))
          .status(200).build();
    else
      return Response.ok().status(204).build();
  }

  @ApiOperation(value = "List all videos available", notes = "Retrieving all videos without any criteria may take a long time", response = VideoRepresentation.class, responseContainer = "List")
  @GET
  @Path(LIST_VIDEOS)
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllVideos() {
    return Response.ok(
        fluentAssembler.assemble(videoRepository.listAllVideos())
            .toListOf(VideoRepresentation.class))
        .build();
  }

  // update

  // delete
}
