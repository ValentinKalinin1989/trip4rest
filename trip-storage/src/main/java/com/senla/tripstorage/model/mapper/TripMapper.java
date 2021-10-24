package com.senla.tripstorage.model.mapper;

import com.senla.tripstorage.model.entity.Trip;
import com.senla.tripstorage.model.dto.TripDTO;
import org.mapstruct.Mapper;

@Mapper
public interface TripMapper {
    TripDTO tripToTripDTO(Trip trip);
    Trip tripDTOtoTrip(TripDTO tripDTO);
}
