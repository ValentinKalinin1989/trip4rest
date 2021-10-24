package com.senla.tripstorage.repository;

import com.senla.tripstorage.model.entity.Trip;
import org.springframework.data.repository.CrudRepository;

public interface TripRepository extends CrudRepository<Trip, Long> {
}
