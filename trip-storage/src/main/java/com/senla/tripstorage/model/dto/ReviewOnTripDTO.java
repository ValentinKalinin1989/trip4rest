package com.senla.tripstorage.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewOnTripDTO {
    private String uuid;
    private UsrLiteInfoDTO usr;
    private TripDTO trip;
    private Integer userRate;
    private String description;
}
