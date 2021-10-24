package com.senla.tripstorage.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsrRegistrationDTO {
    private String uuid;
    private String nickName;
    private String password;
    private String email;
    private String phone;
    private String role;
}
