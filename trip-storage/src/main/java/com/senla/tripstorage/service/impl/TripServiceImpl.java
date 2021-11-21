package com.senla.tripstorage.service.impl;

import com.senla.tripstorage.model.dto.EventDTO;
import com.senla.tripstorage.model.dto.TripDTO;
import com.senla.tripstorage.model.entity.Event;
import com.senla.tripstorage.model.entity.Trip;
import com.senla.tripstorage.model.mapper.EventMapper;
import com.senla.tripstorage.model.mapper.TripMapper;
import com.senla.tripstorage.repository.TripRepository;
import com.senla.tripstorage.service.TripService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TripServiceImpl implements TripService {

    private final TripRepository tripRepository;

    private final TripMapper tripMapper;
    private final EventMapper eventMapper;

    public TripServiceImpl(TripRepository tripRepository, TripMapper tripMapper, EventMapper eventMapper) {
        this.tripRepository = tripRepository;
        this.tripMapper = tripMapper;
        this.eventMapper = eventMapper;
    }

    @Override
    public Set<TripDTO> findAll() {
        return tripRepository.findAll().stream()
                .map(tripMapper::tripToTripDTO)
                .collect(Collectors.toSet());
    }

    @Override
    public TripDTO save(TripDTO tripDTO) {
        return tripMapper.tripToTripDTO(
                tripRepository.save(tripMapper.tripDTOtoTrip(tripDTO))
        );
    }

    @Override
    public TripDTO findByUuid(String uuid) {
        return tripMapper.tripToTripDTO(
                tripRepository.findByUuid(uuid)
        );
    }

    @Override
    public void deleteByUuid(String uuid) {
        tripRepository.findByUuid(uuid);
    }

    @Override
    public TripDTO addEventToTrip(String uuid, EventDTO eventDTO) {
        Trip trip = tripRepository.findByUuid(uuid);
        trip.getEvents().add(eventMapper.eventDTOtoEvent(eventDTO));
        return tripMapper.tripToTripDTO(
                tripRepository.save(trip)
        );
    }

    @Override
    public TripDTO deleteEventFromTrip(String uuidTrip, String uuidEvent) {
        Trip trip = tripRepository.findByUuid(uuidTrip);
        Set<Event>  events = trip.getEvents();
        Event findEvent = null;
        for(Event event : events) {
            if(event.getUuid().equals(uuidEvent)) {
                findEvent = event;
                break;
            }
        }
        if(findEvent != null) {
            trip.getEvents().remove(findEvent);
        }
        return tripMapper.tripToTripDTO(
                tripRepository.save(trip)
                );
    }
}
