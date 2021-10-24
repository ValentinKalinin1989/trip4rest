package com.senla.tripstorage.model.mapper;

import com.senla.tripstorage.model.entity.ReviewOnEvent;
import com.senla.tripstorage.model.dto.ReviewOnEventDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewOnEventMapper {
    ReviewOnEventDTO reviewOnEventToReviewOnEventDTO(ReviewOnEvent reviewOnEvent);
    ReviewOnEvent reviewOnEventDTOtoReviewOnEvent(ReviewOnEventDTO reviewOnEventDTO);
}
