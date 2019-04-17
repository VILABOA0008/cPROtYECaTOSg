package org.videofuture.renter.domain.model.renting;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.seedstack.business.domain.BaseEntity;
import org.seedstack.business.domain.Identity;
import org.seedstack.business.util.inmemory.InMemory;
import org.videofuture.renter.application.utils.SequenceIntGenerator;
import org.videofuture.renter.domain.model.customer.CustomerId;
import org.videofuture.renter.domain.model.video.Video;
import org.videofuture.renter.domain.model.video.VideoId;

@Entity
@Table(name = Renting.TABLE_NAME)
public class Renting extends BaseEntity<RentingId> {

  // column names
  public static final String TABLE_NAME = "rentings";
  public static final String RENTING_ID = "id";
  public static final String VIDEO_ID = "id_video";
  public static final String CUSTOMER_ID = "id_customer";
  public static final String RENTING_DATE = "rentingDate";
  public static final String RETURN_DATE = "returndate";

  @Id
  @Identity(generator = SequenceIntGenerator.class)
  @InMemory
  private Integer id;
  @Column(name = VIDEO_ID, unique = true, nullable = false, insertable = false, updatable = false)
  private VideoId videoId;
  @Column(name = CUSTOMER_ID, unique = true, nullable = false, insertable = false, updatable = false)
  private CustomerId customerId;
  @Column(name = RENTING_DATE, unique = false, nullable = false, insertable = true)
  private LocalDate rentingDate;
  @Column(name = RETURN_DATE, unique = false, nullable = true, insertable = true, updatable = true)
  private LocalDate returnDate;
  @ManyToOne
  @JoinColumn(name="video", nullable = false)
  private Video video;

  Renting() {
    // needed for Hibernate
  }

  public Renting(Video video, CustomerId customerId) {
    this.video = video;
    this.videoId = video.getId();
    this.customerId = customerId;
  }

  @Override
  public RentingId getId() {
    return new RentingId(id);
  }

  public LocalDate getRentingDate() {
    return rentingDate;
  }

  public LocalDate getReturnDate() {
    return returnDate;
  }

  public VideoId getVideoId() {
    return videoId;
  }

  public CustomerId getCustomerId() {
    return customerId;
  }

  public void rent() {
    this.rentingDate = LocalDate.now();
  }

  public void returnRent() {
    this.returnDate = LocalDate.now();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(RENTING_ID + " : " + id + ",\n");
    sb.append(VIDEO_ID + " : " + videoId + ",\n");
    sb.append(CUSTOMER_ID + " : " + customerId + ",\n");
    sb.append(RENTING_DATE + " : " + rentingDate + ",\n");
    sb.append(RETURN_DATE + " : " + returnDate + ",\n");
    return sb.toString();
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Renting)) {
      return false;
    }
    Renting castOther = (Renting) other;
    //Test equality of videoId, customerId and rentingDate
    EqualsBuilder equalsBuilder = new EqualsBuilder();
    return equalsBuilder.append(videoId, castOther.getVideoId())
        .append(customerId, castOther.getCustomerId())
        .append(rentingDate, castOther.getRentingDate()).isEquals();
  }
}