package com.senla.tripstorage.service;

import com.senla.tripstorage.model.dto.UsrFullInfoDTO;
import com.senla.tripstorage.model.dto.UsrInfoDTO;
import com.senla.tripstorage.model.dto.UsrLiteInfoDTO;
import com.senla.tripstorage.model.dto.UsrRegistrationDTO;

import java.util.Set;

public interface UsrService {
    Set<UsrFullInfoDTO> findAllWithFullInfo();
    Set<UsrInfoDTO> findAllWithInfo();
    Set<UsrLiteInfoDTO> findAllWithLiteInfo();
    UsrFullInfoDTO findUsrFullInfoByUuid(String uuid);
    UsrInfoDTO findUsrInfoDTOByUuid(String uuid);
    UsrLiteInfoDTO findUsrLiteInfoDTOByUuid(String uuid);
    UsrLiteInfoDTO save(UsrRegistrationDTO usrRegistrationDTO);
    UsrInfoDTO update(UsrInfoDTO usrInfoDTO);
    void deleteByUuid(String uuid);
    Set<UsrLiteInfoDTO> findFriendsForUsr(String usrUuid);
}
