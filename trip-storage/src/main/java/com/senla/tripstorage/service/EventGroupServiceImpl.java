package com.senla.tripstorage.service;

import com.senla.tripstorage.model.dto.EventGroupDTO;
import com.senla.tripstorage.model.mapper.EventGroupMapper;
import com.senla.tripstorage.repository.EventGroupRepository;
import com.senla.tripstorage.service.impl.EventGroupService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EventGroupServiceImpl implements EventGroupService {
    private final EventGroupRepository eventGroupRepository;
    private final EventGroupMapper eventGroupMapper;

    public EventGroupServiceImpl(EventGroupRepository eventGroupRepository, EventGroupMapper eventGroupMapper) {
        this.eventGroupRepository = eventGroupRepository;
        this.eventGroupMapper = eventGroupMapper;
    }

    @Override
    public Set<EventGroupDTO> findAll() {
        return eventGroupRepository.findAll().stream()
                .map(eventGroupMapper::eventToEventDTO)
                .collect(Collectors.toSet());
    }

    @Override
    public EventGroupDTO findByUuid(String uuid) {
        return eventGroupMapper.eventToEventDTO(eventGroupRepository.findByUuid(uuid));
    }

    @Override
    public void deleteByUuid(String uuid) {
        eventGroupRepository.deleteByUuid(uuid);
    }

    @Override
    public EventGroupDTO save(EventGroupDTO eventGroup) {
        return eventGroupMapper.eventToEventDTO(
                eventGroupRepository.save(eventGroupMapper.eventDTOtoEvent(eventGroup))
        );
    }
}
