package com.senla.tripstorage.service.impl;

import com.senla.tripstorage.model.dto.UsrFullInfoDTO;
import com.senla.tripstorage.model.dto.UsrInfoDTO;
import com.senla.tripstorage.model.dto.UsrLiteInfoDTO;
import com.senla.tripstorage.model.dto.UsrRegistrationDTO;
import com.senla.tripstorage.model.entity.Usr;
import com.senla.tripstorage.model.mapper.UsrMapper;
import com.senla.tripstorage.repository.UsrRepository;
import com.senla.tripstorage.service.UsrService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UsrServiceImpl implements UsrService {

    private final UsrRepository usrRepository;
    private final UsrMapper usrMapper;


    public UsrServiceImpl(UsrRepository usrRepository, UsrMapper usrMapper) {
        this.usrRepository = usrRepository;
        this.usrMapper = usrMapper;
    }

    @Override
    public Set<UsrFullInfoDTO> findAllWithFullInfo() {
        return usrRepository.findAll().stream()
                .map(usrMapper::usrToUsrFullInfoDTO)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<UsrInfoDTO> findAllWithInfo() {
        return usrRepository.findAll().stream()
                .map(usrMapper::usrToUsrInfoDTO)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<UsrLiteInfoDTO> findAllWithLiteInfo() {
        return usrRepository.findAll().stream()
                .map(usrMapper::usrToUsrLiteInfoDTO)
                .collect(Collectors.toSet());
    }

    @Override
    public UsrFullInfoDTO findUsrFullInfoByUuid(String uuid) {
        return usrMapper.usrToUsrFullInfoDTO(
                usrRepository.findByUuid(uuid)
        );
    }

    @Override
    public UsrInfoDTO findUsrInfoDTOByUuid(String uuid) {
        return usrMapper.usrToUsrInfoDTO(
                usrRepository.findByUuid(uuid)
        );
    }

    @Override
    public UsrLiteInfoDTO findUsrLiteInfoDTOByUuid(String uuid) {
        return usrMapper.usrToUsrLiteInfoDTO(
                usrRepository.findByUuid(uuid)
        );
    }

    @Override
    public UsrLiteInfoDTO save(UsrRegistrationDTO usrRegistrationDTO) {
        return usrMapper.usrToUsrLiteInfoDTO(
                usrRepository.save(usrMapper.usrRegistrationDTOtoUsr(usrRegistrationDTO))
        );
    }

    @Override
    public UsrInfoDTO update(UsrInfoDTO usrInfoDTO) {
        Usr usr = usrRepository.findByUuid(usrInfoDTO.getUuid());
        usr.setNickName(usrInfoDTO.getNickName());
        usr.setEmail(usrInfoDTO.getEmail());
        usr.setPhone(usrInfoDTO.getPhone());
        usr.setRole(usrInfoDTO.getRole());
        usr.setIsBlocked(usrInfoDTO.getIsBlocked());
        return usrMapper.usrToUsrInfoDTO(usrRepository.save(usr));
    }

    @Override
    public void deleteByUuid(String uuid) {
        usrRepository.deleteByUuid(uuid);
    }

    @Override
    public Set<UsrLiteInfoDTO> findFriendsForUsr(String usrUuid) {
        return usrRepository.findByUuid(usrUuid).getFriends().stream()
                .map(usrMapper::usrToUsrLiteInfoDTO)
                .collect(Collectors.toSet());
    }
}
