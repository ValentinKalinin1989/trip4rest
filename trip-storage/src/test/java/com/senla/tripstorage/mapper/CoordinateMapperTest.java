package com.senla.tripstorage.mapper;

import com.senla.tripstorage.model.entity.Coordinate;
import com.senla.tripstorage.model.dto.CoordinateDTO;
import com.senla.tripstorage.model.mapper.CoordinateMapper;
import com.senla.tripstorage.model.mapper.CoordinateMapperImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoordinateMapperTest {
    private CoordinateMapper coordinateMapper = new CoordinateMapperImpl();

    @Test
    @DisplayName("Testing CoordinateMapper")
    void coordinateMapperTest() {
        Coordinate coordinate = new Coordinate();
        coordinate.setUuid("df30e38b-e564-47e4-80dc-f8b5c4701383");
        coordinate.setLongitude(0.001f);
        coordinate.setLatitude(3456.890f);
        coordinate.setAddress("ул. Пушкина, д. Колотушкина");
        CoordinateDTO coordinateDTO = coordinateMapper.coordinateToCoordinateDTO(coordinate);

        assertEquals("df30e38b-e564-47e4-80dc-f8b5c4701383", coordinateDTO.getUuid());
        assertEquals(0.001f, coordinateDTO.getLongitude());
        assertEquals(3456.890f, coordinateDTO.getLatitude());
        assertEquals("ул. Пушкина, д. Колотушкина", coordinateDTO.getAddress());
    }
}