package com.senla.tripstorage.model.mapper;

import com.senla.tripstorage.model.entity.EventGroup;
import com.senla.tripstorage.model.dto.EventGroupDTO;
import org.mapstruct.Mapper;

@Mapper
public interface EventGroupMapper {
    EventGroupDTO eventToEventDTO(EventGroup eventGroup);
    EventGroup eventDTOtoEvent(EventGroupDTO eventGroupDTO);
}
