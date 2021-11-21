package com.senla.tripstorage.service.impl;

import com.senla.tripstorage.model.dto.EventDTO;
import com.senla.tripstorage.model.dto.PlaceDTO;
import com.senla.tripstorage.model.entity.Place;
import com.senla.tripstorage.model.mapper.EventMapper;
import com.senla.tripstorage.model.mapper.PlaceMapper;
import com.senla.tripstorage.repository.PlaceRepository;
import com.senla.tripstorage.service.PlaceService;

import java.util.Set;
import java.util.stream.Collectors;

public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository placeRepository;
    private final PlaceMapper placeMapper;
    private final EventMapper eventMapper;

    public PlaceServiceImpl(PlaceRepository placeRepository, PlaceMapper placeMapper, EventMapper eventMapper) {
        this.placeRepository = placeRepository;
        this.placeMapper = placeMapper;
        this.eventMapper = eventMapper;
    }

    @Override
    public Set<PlaceDTO> findAll() {
        return placeRepository.findAll().stream()
                .map(placeMapper::placeToPlaceDTO)
                .collect(Collectors.toSet());
    }

    @Override
    public PlaceDTO save(PlaceDTO placeDTO) {
        return placeMapper.placeToPlaceDTO(
                placeRepository.save(placeMapper.placeDTOtoPlace(placeDTO))
        );
    }

    @Override
    public PlaceDTO findByUuid(String uuid) {
        return placeMapper.placeToPlaceDTO(
                placeRepository.findByUuid(uuid)
        );
    }

    @Override
    public void deleteByUuid(String uuid) {
        placeRepository.deleteByUuid(uuid);
    }

    @Override
    public PlaceDTO addEventToPlace(String uuidPlace, EventDTO eventDTO) {
        Place place = placeRepository.findByUuid(uuidPlace);
        place.getEvents().add(eventMapper.eventDTOtoEvent(eventDTO));
        return placeMapper.placeToPlaceDTO(placeRepository.save(place));
    }

    @Override
    public Set<EventDTO> findAllEventFoPlaceByUuid(String uuidPlace) {
        return null;
    }
}
