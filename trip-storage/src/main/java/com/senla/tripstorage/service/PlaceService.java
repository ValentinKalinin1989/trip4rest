package com.senla.tripstorage.service;

import com.senla.tripstorage.model.dto.EventDTO;
import com.senla.tripstorage.model.dto.PlaceDTO;

import java.util.Set;

public interface PlaceService {
    Set<PlaceDTO> findAll();
    PlaceDTO save(PlaceDTO placeDTO);
    PlaceDTO findByUuid(String uuid);
    void deleteByUuid(String uuid);
    PlaceDTO addEventToPlace(String uuidPlace, EventDTO eventDTO);
    Set<EventDTO> findAllEventFoPlaceByUuid(String uuidPlace);

}
