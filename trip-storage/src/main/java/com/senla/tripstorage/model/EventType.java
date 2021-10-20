package com.senla.tripstorage.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * типы событий
 * например, для группы кино - триллер, комедия,
 * для активного отдыха - страйкбол, пейнтболл;
 */
@Data
@Entity
@Table(name = "event_types")
public class EventType {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "uuid", unique = true)
    private String uuid;

    private String eventTypeName;

    @ManyToMany
    @JoinTable(
            name = "plofile_to_event_type",
            joinColumns = @JoinColumn(name = "event_type_uuid"),
            inverseJoinColumns = @JoinColumn(name = "profile_uuid")
    )
    private Set<Profile> profiles;
}
