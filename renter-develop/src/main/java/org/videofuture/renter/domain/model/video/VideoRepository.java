package org.videofuture.renter.domain.model.video;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.seedstack.business.domain.Repository;

public interface VideoRepository extends Repository<Video, VideoId> {

  public default List<Video> listAllVideos() {
    return this.get(this.getSpecificationBuilder().of(Video.class)
        .all()
        .build())
        .collect(Collectors.toList());
  }
  
  public Optional<Video> getById(int id);
}
