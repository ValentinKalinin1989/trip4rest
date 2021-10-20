package com.senla.tripstorage.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
public class TripDTO {
    private String uuid;
    private Set<UsrLiteInfoDTO> usrs;
    private Set<EventDTO> events;
    private CoordinateDTO startCoordinate;
    private CoordinateDTO endCoordinate;
    private Long tripLength;
    private Long durationTime;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
}
