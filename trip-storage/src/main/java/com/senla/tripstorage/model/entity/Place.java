package com.senla.tripstorage.model.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * место, где происходят события,
 * например: кино, парк, театр, стрйкбольный клуб
 * состоит из:
 * координат (широты и долготы)
 * координат (улицы, дома, строения)
 * группы событий
 */
@Data
@Entity
@Table(name = "places")
public class Place {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "uuid", unique = true)
    private String uuid;

    @Column(name = "type_place")
    private String type;
    private String name;
    private String description;

    @OneToOne
    @JoinColumn(name = "coordinates_uuid")
    private Coordinate coordinate;

    private String phone;
    private String site;
    @Column(name = "info_place")
    private String info;
    @Column(name = "work_time")
    private String workTime;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn (name = "place_uuid")
    private Set<Event> events;
}
