package org.videofuture.renter.domain.model.video;

import java.sql.Date;

import org.seedstack.business.domain.Factory;

public interface VideoFactory extends Factory<Video> {
  public Video create(String title, String director, Date releaseDate);
}
