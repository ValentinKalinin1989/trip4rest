package com.senla.tripstorage.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * координаты состоят из:
 * долготы,
 * широты,
 * адреса
 */
@Data
@Entity
@Table(name = "coordinates")
public class Coordinate {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "uuid", unique = true)
    private String uuid;

    private Float longitude;
    private Float latitude;
    private String address;
}
