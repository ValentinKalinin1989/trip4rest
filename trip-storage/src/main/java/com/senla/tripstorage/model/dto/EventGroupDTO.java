package com.senla.tripstorage.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class EventGroupDTO {
    private String uuid;
    private String name;
    private Set<EventTypeDTO> eventTypes;
}
