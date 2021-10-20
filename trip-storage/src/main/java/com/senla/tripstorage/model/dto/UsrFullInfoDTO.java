package com.senla.tripstorage.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UsrFullInfoDTO {
    private String uuid;
    private String nickName;
    private String email;
    private String phone;
    private String role;
    private Boolean isBlocked;
    private Set<UsrLiteInfoDTO> friends;
    private Set<UsrLiteInfoDTO> usrs;
    private Set<ChatDTO> chats;
    private Set<MessageDTO> messages;
    private Set<ProfileDTO> profiles;
    private Set<TripDTO> trips;
    private Set<ReviewOnTripDTO> reviewOnEvents;
    private Set<ReviewOnPlaceDTO> reviewOnPlaces;
    private Set<ReviewOnEventDTO> reviewOnTrips;
}
