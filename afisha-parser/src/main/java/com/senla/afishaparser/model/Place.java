package com.senla.afishaparser.model;

import lombok.Data;

@Data
public class Place {

    private String uuid;
    private String type;
    private String name;
    private String description;
    private Coordinate coordinate;
    private String phone;
    private String site;
    private String info;
    private String workTime;
}