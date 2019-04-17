package org.videofuture.renter.domain.model.video;

import java.sql.Date;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.seedstack.business.domain.BaseAggregateRoot;
import org.seedstack.business.domain.Identity;
import org.seedstack.business.util.inmemory.InMemory;
import org.videofuture.renter.application.utils.SequenceIntGenerator;
import org.videofuture.renter.domain.exceptions.RentingDoesNotExistException;
import org.videofuture.renter.domain.exceptions.RentingException;
import org.videofuture.renter.domain.model.customer.CustomerId;
import org.videofuture.renter.domain.model.renting.Renting;
import org.videofuture.renter.domain.model.renting.RentingId;

@Entity
@Table(name = Video.TABLE_NAME)
public class Video extends BaseAggregateRoot<VideoId> {

  // column names
  public static final String TABLE_NAME = "videos";
  public static final String VIDEO_ID = "id";
  public static final String TITLE = "title";
  public static final String DIRECTOR = "director";
  public static final String RELEASE_DATE = "releaseDate";
  public static final String RENTED = "rented";

  @Id
  @Identity(generator = SequenceIntGenerator.class)
  @InMemory
  @Column(name = "id", nullable = false, insertable = true, updatable = false)
  private Integer id;
  @Column(name = TITLE, nullable = true, insertable = true, updatable = true)
  private String title;
  @Column(name = DIRECTOR, nullable = true, insertable = true, updatable = true)
  private String director;
  @Column(name = RELEASE_DATE, nullable = true, insertable = true, updatable = true)
  private Date releaseDate;
  @Column(name = RENTED, nullable = true, insertable = true, updatable = true)
  private boolean rented;
  @OneToMany(mappedBy = "video")
  private Set<Renting> rentings;

  // needed for Hibernate
  public Video() {
    this.rentings = new HashSet<>();
  }

  public Video(String title, String director, Date releaseDate) {
    this();
    this.title = title;
    this.director = director;
    this.releaseDate = releaseDate;
    this.rented = false;
  }

  @Override
  public VideoId getId() {
    return new VideoId(id);
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }

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

  public Set<Renting> getRentings() {
    return Collections.unmodifiableSet(rentings);
  }

  public Renting getRentingById(RentingId rentingId) {
    return rentings.stream().filter(
        renting -> renting.getId().equals(rentingId)).findFirst().get();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(VIDEO_ID + " : " + id + ",\n");
    sb.append(TITLE + " : " + title + ",\n");
    sb.append(DIRECTOR + " : " + director + ",\n");
    sb.append(RELEASE_DATE + " : " + releaseDate + ",\n");
    sb.append(RENTED + " : " + rented + ",\n");
    return sb.toString();
  }

  public Renting createRent(CustomerId customerId) {
    Renting newRenting = new Renting(this, customerId);
    rentings.add(newRenting);
    return newRenting;
  }

  public void returnRent(Renting renting) throws RentingDoesNotExistException {
    if (!rentings.contains(renting))
      throw new RentingDoesNotExistException();
    rentings.forEach(x -> {
      if (x.equals(renting))
        x.returnRent();
    });
  }
}
