package org.videofuture.renter.interfaces.dto.video;

import org.seedstack.business.assembler.BaseAssembler;
import org.videofuture.renter.domain.model.video.Video;

public class VideoAssembler extends BaseAssembler<Video, VideoRepresentation> {

  @Override
  public void mergeAggregateIntoDto(Video sourceAggregate, VideoRepresentation targetDto) {
    targetDto.setId(sourceAggregate.getId().getValue());
    targetDto.setTitle(sourceAggregate.getTitle());
    targetDto.setDirector(sourceAggregate.getDirector());
    targetDto.setReleaseDate(sourceAggregate.getReleaseDate());
    targetDto.setRented(sourceAggregate.isRented());
  }

  @Override
  public void mergeDtoIntoAggregate(VideoRepresentation sourceDto, Video targetAggregate) {
    targetAggregate.setTitle(sourceDto.getTitle());
    targetAggregate.setDirector(sourceDto.getDirector());
    targetAggregate.setReleaseDate(sourceDto.getReleaseDate());
    targetAggregate.setRented(sourceDto.isRented());
  }
}