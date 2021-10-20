package com.senla.tripstorage.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewOnPlaceDTO {
    private String uuid;
    private UsrLiteInfoDTO usr;
    private PlaceDTO place;
    private Integer userRate;
    private String description;
}
