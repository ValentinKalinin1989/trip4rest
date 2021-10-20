package com.senla.tripstorage.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * хранение групп событий,
 * например, кино, театр, активный отдых и т.д.
 */
@Data
@Entity
@Table(name = "event_groups")
public class EventGroup {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "uuid", unique = true)
    private String uuid;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn (name = "event_types_uuid")
    private Set<EventType> eventTypes;
}
