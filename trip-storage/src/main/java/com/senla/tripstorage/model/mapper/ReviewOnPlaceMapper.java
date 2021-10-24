package com.senla.tripstorage.model.mapper;

import com.senla.tripstorage.model.entity.ReviewOnPlace;
import com.senla.tripstorage.model.dto.ReviewOnPlaceDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ReviewOnPlaceMapper {
    ReviewOnPlaceDTO reviewOnPlaceToReviewOnPlaceDTO(ReviewOnPlace reviewOnPlace);
    ReviewOnPlace reviewOnPlaceDTOtoReviewOnPlace(ReviewOnPlaceDTO reviewOnPlaceDTO);
}
