package com.senla.tripstorage.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsrInfoDTO {
    private String uuid;
    private String nickName;
    private String email;
    private String phone;
    private String role;
    private Boolean isBlocked;
}
