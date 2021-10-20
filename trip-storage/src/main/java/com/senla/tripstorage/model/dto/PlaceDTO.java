package com.senla.tripstorage.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaceDTO {
    private String uuid;

    private String name;
    private String description;
    private CoordinateDTO coordinate;

}
