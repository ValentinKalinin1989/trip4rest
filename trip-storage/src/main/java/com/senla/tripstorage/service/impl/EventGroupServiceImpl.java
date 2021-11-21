package com.senla.tripstorage.service.impl;

import com.senla.tripstorage.model.dto.EventGroupDTO;
import com.senla.tripstorage.model.dto.EventTypeDTO;
import com.senla.tripstorage.model.entity.EventGroup;
import com.senla.tripstorage.model.mapper.EventGroupMapper;
import com.senla.tripstorage.model.mapper.EventTypeMapper;
import com.senla.tripstorage.repository.EventGroupRepository;
import com.senla.tripstorage.service.EventGroupService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EventGroupServiceImpl implements EventGroupService {
    private final EventGroupRepository eventGroupRepository;
    private final EventGroupMapper eventGroupMapper;
    private final EventTypeMapper eventTypeMapper;

    public EventGroupServiceImpl(EventGroupRepository eventGroupRepository, EventGroupMapper eventGroupMapper, EventTypeMapper eventTypeMapper) {
        this.eventGroupRepository = eventGroupRepository;
        this.eventGroupMapper = eventGroupMapper;
        this.eventTypeMapper = eventTypeMapper;
    }

    @Override
    public Set<EventGroupDTO> findAll() {
        return eventGroupRepository.findAll().stream()
                .map(eventGroupMapper::toEventGroupDTO)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<EventTypeDTO> findAllEventTypesForGroup(String uuid) {
        return eventGroupRepository.findByUuid(uuid).getEventTypes()
                .stream().map(eventTypeMapper::toEventTypeDTO)
                .collect(Collectors.toSet());
    }

    @Override
    public EventGroupDTO findByUuid(String uuid) {
        return eventGroupMapper.toEventGroupDTO(eventGroupRepository.findByUuid(uuid));
    }

    @Override
    public void deleteByUuid(String uuid) {
        eventGroupRepository.deleteByUuid(uuid);
    }

    @Override
    public EventGroupDTO save(EventGroupDTO eventGroup) {
        return eventGroupMapper.toEventGroupDTO(
                eventGroupRepository.save(eventGroupMapper.toEventGroup(eventGroup))
        );
    }

    @Override
    public EventGroupDTO saveEventTypeForGroup(String uuid, EventTypeDTO eventTypeDTO) {
        EventGroup eventGroup = eventGroupRepository.findByUuid(uuid);
        eventGroup.getEventTypes().add(eventTypeMapper.toEventType(eventTypeDTO));
        return eventGroupMapper.toEventGroupDTO(eventGroupRepository.save(eventGroup));
    }
}
