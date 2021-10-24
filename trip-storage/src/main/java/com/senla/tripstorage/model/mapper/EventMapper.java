package com.senla.tripstorage.model.mapper;

import com.senla.tripstorage.model.entity.Event;
import com.senla.tripstorage.model.dto.EventDTO;
import org.mapstruct.Mapper;

@Mapper
public interface EventMapper {
    EventDTO eventToEventDTO(Event event);
    Event eventDTOtoEvent(EventDTO eventDTO);
}
