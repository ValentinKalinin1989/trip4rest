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

    private String name;
    private String description;

    @OneToOne
    @JoinColumn(name = "coordinates_uuid")
    private Coordinate coordinate;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn (name = "place_uuid")
    private Set<Event> events;
}
