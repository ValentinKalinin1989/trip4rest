package com.senla.tripstorage.model.mapper;

import com.senla.tripstorage.model.entity.ReviewOnTrip;
import com.senla.tripstorage.model.dto.ReviewOnTripDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ReviewOnTripMapper {
    ReviewOnTripDTO reviewOnTripToReviewOnTripDTO(ReviewOnTrip reviewOnTrip);
    ReviewOnTrip reviewOnTripDTOtoReviewOnTrip(ReviewOnTripDTO reviewOnTripDTO);
}
