package com.senla.tripstorage.controller;

import com.senla.tripstorage.model.dto.UsrInfoDTO;
import com.senla.tripstorage.model.dto.UsrLiteInfoDTO;
import com.senla.tripstorage.model.dto.UsrRegistrationDTO;
import com.senla.tripstorage.service.UsrService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("v1.0/usr")
public class UsrController {

    private final UsrService usrService;

    public UsrController(UsrService usrService) {
        this.usrService = usrService;
    }

    @GetMapping
    public Set<UsrInfoDTO> getAllUsrInfo() {
        return usrService.findAllWithInfo();
    }

    @GetMapping("{usrUuid}")
    public UsrInfoDTO getUsrInfoByUuid(@PathVariable String usrUuid) {
        return usrService.findUsrInfoDTOByUuid(usrUuid);
    }

    @GetMapping("{usrUuid}/friend")
    public Set<UsrLiteInfoDTO> getFriendsForUsr(@PathVariable String usrUuid) {
        return usrService.findFriendsForUsr(usrUuid);
    }

    @PostMapping
    public UsrLiteInfoDTO saveUsr(@RequestBody UsrRegistrationDTO usrRegistrationDTO) {
        return usrService.save(usrRegistrationDTO);
    }

    @PutMapping
    public UsrInfoDTO updateUsrInfo(@RequestBody UsrInfoDTO usrInfoDTO) {
        return usrService.update(usrInfoDTO);
    }

    @DeleteMapping("{usrUuid}")
    public void deleteByUuid(@PathVariable String usrUuid) {
        usrService.deleteByUuid(usrUuid);
    }
}
