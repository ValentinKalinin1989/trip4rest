package com.senla.tripstorage.model.mapper;

import com.senla.tripstorage.model.entity.Usr;
import com.senla.tripstorage.model.dto.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsrMapper {
    Usr usrRegistrationDTOtoUsr(UsrRegistrationDTO usrRegistrationDTO);
    UsrCredentialDTO usrToUsrCredentialDTO(Usr usr);
    UsrFullInfoDTO usrToUsrFullInfoDTO(Usr usr);
    UsrInfoDTO usrToUsrInfoDTO(Usr usr);
    UsrLiteInfoDTO usrToUsrLiteInfoDTO(Usr usr);
}
