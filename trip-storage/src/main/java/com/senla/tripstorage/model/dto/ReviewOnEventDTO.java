package com.senla.tripstorage.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewOnEventDTO {
    private String uuid;
    private UsrLiteInfoDTO usr;
    private EventDTO event;
    private Integer userRate;
    private String description;
}
