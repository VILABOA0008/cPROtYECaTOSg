package org.videofuture.renter.domain.services.renting;

import org.seedstack.business.Service;
import org.videofuture.renter.domain.exceptions.RentingException;
import org.videofuture.renter.domain.model.customer.CustomerId;
import org.videofuture.renter.domain.model.video.VideoId;

@Service
public interface RentingService {

  void rent(CustomerId customerId, VideoId videoId)
      throws RentingException;
}
