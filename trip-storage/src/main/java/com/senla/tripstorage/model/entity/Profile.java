package com.senla.tripstorage.model.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * состоит из типов событий и привязывается к пользователю
 * на основе него происходит генерация маршрута
 */
@Data
@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "uuid", unique = true)
    private String uuid;

    @ManyToMany
    @JoinTable(
            name = "usr_to_profile",
            joinColumns = @JoinColumn(name = "profile_uuid"),
            inverseJoinColumns = @JoinColumn(name = "usr_uuid")
    )
    private Set<Usr> usrs;

    @ManyToMany
    @JoinTable(
            name = "plofile_to_event_type",
            joinColumns = @JoinColumn(name = "profile_uuid"),
            inverseJoinColumns = @JoinColumn(name = "event_type_uuid")
    )
    private Set<EventType> eventTypes;
}
