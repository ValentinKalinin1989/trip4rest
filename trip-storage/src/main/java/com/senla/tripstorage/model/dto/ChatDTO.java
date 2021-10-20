package com.senla.tripstorage.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ChatDTO {
    private String uuid;
    private List<UsrLiteInfoDTO> usrs;
    private List<MessageDTO> messages;
}
