package com.senla.tripstorage.model.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * пользователь состоит из:
 * никнейма
 * роли
 * статуса заблокирован или нет
 * списка друзей
 * списка чатов
 * списка сообщений
 * списка профилей
 * маршрутов
 * отзывов на события
 * отзывов на места
 * отзывов на маршруты
 */
@Data
@Entity
@Table(name = "usrs")
public class Usr {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "uuid", unique = true)
    private String uuid;

    private String nickName;
    private String password;
    private String email;
    private String phone;
    private String role;
    private Boolean isBlocked;

    @ManyToMany
    @JoinTable(
            name = "usr_to_friend",
            joinColumns = @JoinColumn(name = "friend_uuid"),
            inverseJoinColumns = @JoinColumn(name = "usr_uuid")
    )
    private Set<Usr> friends;

    @ManyToMany
    @JoinTable(
            name = "usr_to_friend",
            joinColumns = @JoinColumn(name = "usr_uuid"),
            inverseJoinColumns = @JoinColumn(name = "friend_uuid")
    )
    private Set<Usr> usrs;

    @ManyToMany
    @JoinTable(
            name = "usr_to_chat",
            joinColumns = @JoinColumn(name = "usr_uuid"),
            inverseJoinColumns = @JoinColumn(name = "chat_uuid")
    )
    private Set<Chat> chats;

    @OneToMany(mappedBy = "usr")
    private Set<Message> messages;

    @ManyToMany
    @JoinTable(
            name = "usr_to_profile",
            joinColumns = @JoinColumn(name = "usr_uuid"),
            inverseJoinColumns = @JoinColumn(name = "profile_uuid")
    )
    private Set<Profile> profiles;

    @ManyToMany
    @JoinTable(
            name = "usr_to_trip",
            joinColumns = @JoinColumn(name = "usr"),
            inverseJoinColumns = @JoinColumn(name = "trip")
    )
    private Set<Trip> trips;

    @OneToMany
    @JoinColumn(name = "usr_uuid")
    private Set<ReviewOnTrip> reviewOnEvents;
    @OneToMany
    @JoinColumn(name = "usr_uuid")
    private Set<ReviewOnPlace> reviewOnPlaces;
    @OneToMany
    @JoinColumn(name = "usr_uuid")
    private Set<ReviewOnEvent> reviewOnTrips;
}
