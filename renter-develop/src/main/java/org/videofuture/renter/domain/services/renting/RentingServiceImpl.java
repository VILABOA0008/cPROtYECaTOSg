package org.videofuture.renter.domain.services.renting;

import java.util.Optional;

import javax.inject.Inject;

import org.videofuture.renter.domain.exceptions.AlreadyRentedException;
import org.videofuture.renter.domain.exceptions.CustomerNotFoundException;
import org.videofuture.renter.domain.exceptions.RentingException;
import org.videofuture.renter.domain.exceptions.VideoNotFoundException;
import org.videofuture.renter.domain.model.customer.CustomerId;
import org.videofuture.renter.domain.model.customer.CustomerRepository;
import org.videofuture.renter.domain.model.renting.Renting;
import org.videofuture.renter.domain.model.video.Video;
import org.videofuture.renter.domain.model.video.VideoId;
import org.videofuture.renter.domain.model.video.VideoRepository;

public class RentingServiceImpl implements RentingService {

  private VideoRepository videoRepository;
  private CustomerRepository customerRepository;

  @Inject
  public RentingServiceImpl(VideoRepository videoRepository,
      CustomerRepository customerRepository) {
    this.videoRepository = videoRepository;
    this.customerRepository = customerRepository;
  }

  // Creates new renting entity to persist in a Renting aggregate
  @Override
  public void rent(CustomerId customerId, VideoId videoId)
      throws RentingException {
    Optional<Video> allegedVideo = videoRepository.getById(videoId.getValue()); //get method doesn't work, just getById, ask an unexpected 
    isRenteable(allegedVideo, customerId);
    // Create renting and set its rentingDate with rent()
    Video video = allegedVideo.get();
    Renting newRenting = video.createRent(customerId);
    newRenting.rent();
    videoRepository.update(video);
  }

  private void isRenteable(Optional<Video> allegedVideo, CustomerId customerId)
      throws RentingException {
    // check if customer exists
    if (!customerRepository.contains(customerId))
      throw new CustomerNotFoundException();
    // check if video exists and if it is already rented
    if (!allegedVideo.isPresent())
      throw new VideoNotFoundException();
    if (allegedVideo.get().isRented()) {
      throw new AlreadyRentedException();
    }
  }
}
