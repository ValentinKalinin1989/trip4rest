package com.senla.tripstorage.service.impl;

import com.senla.tripstorage.model.dto.EventGroupDTO;

import java.util.Set;

public interface EventGroupService{
    Set<EventGroupDTO> findAll();
    EventGroupDTO findByUuid(String uuid);
    void deleteByUuid(String uuid);
    EventGroupDTO save(EventGroupDTO eventGroupDTO);
}
