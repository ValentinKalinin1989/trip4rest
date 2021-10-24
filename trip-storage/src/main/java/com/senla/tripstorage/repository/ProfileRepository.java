package com.senla.tripstorage.repository;

import com.senla.tripstorage.model.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
