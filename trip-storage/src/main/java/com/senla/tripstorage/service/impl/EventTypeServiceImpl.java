package com.senla.tripstorage.service.impl;

import com.senla.tripstorage.repository.EventTypeRepository;
import com.senla.tripstorage.service.EventTypeService;
import org.springframework.stereotype.Service;

@Service
public class EventTypeServiceImpl implements EventTypeService {
    private final EventTypeRepository eventTypeRepository;

    public EventTypeServiceImpl(EventTypeRepository eventTypeRepository) {
        this.eventTypeRepository = eventTypeRepository;
    }

    @Override
    public void deleteByUuid(String uuid) {
        eventTypeRepository.deleteByUuid(uuid);
    }
}
