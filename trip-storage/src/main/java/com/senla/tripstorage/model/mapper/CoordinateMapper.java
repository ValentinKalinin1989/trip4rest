package com.senla.tripstorage.model.mapper;

import com.senla.tripstorage.model.entity.Coordinate;
import com.senla.tripstorage.model.dto.CoordinateDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoordinateMapper {
    CoordinateDTO coordinateToCoordinateDTO(Coordinate coordinate);
    Coordinate coordinateDTOtoCoordinate(CoordinateDTO coordinateDTO);
}
