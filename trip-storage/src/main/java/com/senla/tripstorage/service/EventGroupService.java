package com.senla.tripstorage.service;

import com.senla.tripstorage.model.dto.EventGroupDTO;
import com.senla.tripstorage.model.dto.EventTypeDTO;

import java.util.Set;

public interface EventGroupService{
    Set<EventGroupDTO> findAll();
    Set<EventTypeDTO> findAllEventTypesForGroup(String uuid);
    EventGroupDTO findByUuid(String uuid);
    void deleteByUuid(String uuid);
    EventGroupDTO save(EventGroupDTO eventGroupDTO);
    EventGroupDTO saveEventTypeForGroup(String uuid, EventTypeDTO eventTypeDTO);
}
