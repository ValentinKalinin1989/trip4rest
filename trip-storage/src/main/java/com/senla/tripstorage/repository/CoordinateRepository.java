package com.senla.tripstorage.repository;

import com.senla.tripstorage.model.entity.Coordinate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordinateRepository extends JpaRepository<Coordinate, Long> {
}
