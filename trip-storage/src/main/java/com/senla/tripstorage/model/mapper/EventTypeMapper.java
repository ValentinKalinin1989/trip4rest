package com.senla.tripstorage.model.mapper;

import com.senla.tripstorage.model.entity.EventType;
import com.senla.tripstorage.model.dto.EventTypeDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventTypeMapper {
    EventTypeDTO toEventTypeDTO(EventType eventType);
    EventType toEventType(EventTypeDTO eventTypeDTO);
}
