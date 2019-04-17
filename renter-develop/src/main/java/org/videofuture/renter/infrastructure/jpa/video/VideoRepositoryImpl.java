package org.videofuture.renter.infrastructure.jpa.video;

import java.util.Optional;

import org.seedstack.jpa.BaseJpaRepository;
import org.videofuture.renter.domain.model.video.Video;
import org.videofuture.renter.domain.model.video.VideoId;
import org.videofuture.renter.domain.model.video.VideoRepository;

public class VideoRepositoryImpl extends BaseJpaRepository<Video, VideoId>
    implements VideoRepository {

  @Override
  public Optional<Video> getById(int id) {
    return this.get(
        this.getSpecificationBuilder().of(Video.class)
            .property("id").equalTo(id)
            .build())
        .findFirst();
  }
}
