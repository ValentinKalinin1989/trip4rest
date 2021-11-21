package com.senla.tripstorage.repository;

import com.senla.tripstorage.model.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {
    Trip findByUuid(String uuid);
}
