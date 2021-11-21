package com.senla.tripstorage.model.mapper;

import com.senla.tripstorage.model.entity.EventGroup;
import com.senla.tripstorage.model.dto.EventGroupDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventGroupMapper {
    EventGroupDTO toEventGroupDTO(EventGroup eventGroup);
    EventGroup toEventGroup(EventGroupDTO eventGroupDTO);
}
