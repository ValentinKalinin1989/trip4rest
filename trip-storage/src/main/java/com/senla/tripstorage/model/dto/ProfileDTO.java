package com.senla.tripstorage.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ProfileDTO {
    private String uuid;
    private Set<UsrLiteInfoDTO> usrs;
    private Set<EventTypeDTO> eventTypes;
}
