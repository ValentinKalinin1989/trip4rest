package com.senla.tripstorage.repository;

import com.senla.tripstorage.model.entity.Coordinate;
import org.springframework.data.repository.CrudRepository;

public interface CoordinateRepository extends CrudRepository<Coordinate, Long> {
}
