package org.videofuture.renter.interfaces.dto.video;

import java.sql.Date;

import org.seedstack.business.domain.BaseFactory;
import org.videofuture.renter.domain.model.video.Video;
import org.videofuture.renter.domain.model.video.VideoFactory;

public class VideoFactoryImpl extends BaseFactory<Video> implements VideoFactory {

  public Video create(String title, String director, Date releaseDate) {
    Video tmp = this.create();
    tmp.setTitle(title);
    tmp.setDirector(director);
    tmp.setReleaseDate(releaseDate);
    tmp.setRented(false);
    return tmp;
  }
}
