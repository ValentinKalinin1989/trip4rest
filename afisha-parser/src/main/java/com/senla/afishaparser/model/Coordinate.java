package com.senla.afishaparser.model;

import lombok.Data;

@Data
public class Coordinate {

    private String uuid;
    private Float longitude;
    private Float latitude;
    private String address;
}
