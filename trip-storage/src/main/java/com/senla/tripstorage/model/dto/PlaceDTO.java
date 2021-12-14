package com.senla.tripstorage.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaceDTO {
    private String uuid;
    private String type;
    private String name;
    private String description;
    private CoordinateDTO coordinate;
    private String phone;
    private String site;
    private String info;
    private String workTime;

}
