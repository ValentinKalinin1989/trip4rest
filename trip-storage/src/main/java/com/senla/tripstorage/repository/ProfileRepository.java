package com.senla.tripstorage.repository;

import com.senla.tripstorage.model.entity.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}
