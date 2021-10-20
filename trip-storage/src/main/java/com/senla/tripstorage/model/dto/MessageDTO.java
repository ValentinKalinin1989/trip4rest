package com.senla.tripstorage.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MessageDTO {
    private String uuid;
    private UsrLiteInfoDTO usr;
    private String text;
    private LocalDateTime dateTime;
}
