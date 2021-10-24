package com.senla.tripstorage.model.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * маршрут состоит из:
 * цепочки событий
 * начальная координата
 * конечная координата
 * длина
 * времи маршрута
 * времени начала и времени конца маршрута
 * координат начала и конца маршрута
 * протяженности маршрута
 */
@Data
@Entity
@Table(name = "trips")
public class Trip {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "uuid", unique = true)
    private String uuid;

    @ManyToMany
    @JoinTable(
            name = "usr_to_trip",
            joinColumns = @JoinColumn(name = "trip"),
            inverseJoinColumns = @JoinColumn(name = "usr")
    )
    private Set<Usr> usrs;

    @ManyToMany
    @JoinTable(
            name = "trip_to_event",
            joinColumns = @JoinColumn(name = "trip_uuid"),
            inverseJoinColumns = @JoinColumn(name = "event_uuid")
    )
    private Set<Event> events;

    @ManyToOne
    private Coordinate startCoordinate;
    @ManyToOne
    private Coordinate endCoordinate;
    private Long tripLength;
    private Long durationTime;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
}
