package com.senla.tripstorage.model.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * событие, из которых состоит маршрут
 * состоит из:
 * типа события
 * название события
 * описание события
 * веремени начала и конца события
 * длительности события
 * признак необходимо ли посещать событие от начала до конца
 * (сеанс в кино необходимо посещать от начала до конца, в ресторан китайской кухни можно прийти в любой период)
 */
@Data
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "uuid", unique = true)
    private String uuid;

    @OneToOne
    @JoinColumn(name = "event_type_uuid")
    private EventType eventType;
    private String name;
    private String description;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Long durationTime;
}
