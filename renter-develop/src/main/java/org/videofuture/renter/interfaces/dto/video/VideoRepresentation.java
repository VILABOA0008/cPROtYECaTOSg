package org.videofuture.renter.interfaces.dto.video;

import java.sql.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.seedstack.business.assembler.AggregateId;  
import org.seedstack.business.assembler.FactoryArgument;
import org.videofuture.renter.domain.model.video.Video;

public class VideoRepresentation {

  private int id;
  private String title;
  private String director;
  private Date releaseDate;
  private boolean rented;

  @AggregateId
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @FactoryArgument(index = 0)
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @FactoryArgument(index = 1)
  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  @FactoryArgument(index = 2)
  public Date getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(Date releaseDate) {
    this.releaseDate = releaseDate;
  }

  public boolean isRented() {
    return rented;
  }

  public void setRented(boolean rented) {
    this.rented = rented;
  }

  @Override
  public boolean equals(final Object other) {
    if (!(other instanceof VideoRepresentation)) {
      return false;
    }
    VideoRepresentation castOther = (VideoRepresentation) other;
    return new EqualsBuilder()
        .append(id, castOther.getId())
        .append(title, castOther.getTitle())
        .append(director, castOther.getDirector())
        .append(releaseDate, castOther.getReleaseDate())
        .append(rented, castOther.isRented())
        .isEquals();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(Video.VIDEO_ID + " : " + id + ",\n");
    sb.append(Video.TITLE + " : " + title + ",\n");
    sb.append(Video.DIRECTOR + " : " + director + ",\n");
    sb.append(Video.RELEASE_DATE + " : " + releaseDate + ",\n");
    sb.append(Video.RENTED + " : " + rented + "\n");
    return sb.toString();
  }

}
