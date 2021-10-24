package com.senla.tripstorage.model.mapper;

import com.senla.tripstorage.model.entity.Place;
import com.senla.tripstorage.model.dto.PlaceDTO;
import org.mapstruct.Mapper;

@Mapper
public interface PlaceMapper {
    PlaceDTO placeToPlaceDTO(Place place);
    Place placeDTOtoPlace(PlaceDTO placeDTO);
}
