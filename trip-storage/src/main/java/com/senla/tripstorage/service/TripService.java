package com.senla.tripstorage.service;

import com.senla.tripstorage.model.dto.EventDTO;
import com.senla.tripstorage.model.dto.TripDTO;

import java.util.Set;

public interface TripService {
    Set<TripDTO> findAll();
    TripDTO save(TripDTO tripDTO);
    TripDTO findByUuid(String uuid);
    void deleteByUuid(String uuid);
    TripDTO addEventToTrip(String uuid, EventDTO eventDTO);
    TripDTO deleteEventFromTrip(String uuidTrip, String uuidEvent);
}
