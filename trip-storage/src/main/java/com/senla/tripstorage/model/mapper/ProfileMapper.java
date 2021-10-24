package com.senla.tripstorage.model.mapper;

import com.senla.tripstorage.model.entity.Profile;
import com.senla.tripstorage.model.dto.ProfileDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    ProfileDTO profileToProfileDTO(Profile profile);
    Profile profileDTOtoProfile(ProfileDTO profileDTO);
}
