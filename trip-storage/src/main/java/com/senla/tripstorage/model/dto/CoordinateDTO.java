package com.senla.tripstorage.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoordinateDTO {
    private String uuid;
    private Float longitude;
    private Float latitude;
    private String address;
}
