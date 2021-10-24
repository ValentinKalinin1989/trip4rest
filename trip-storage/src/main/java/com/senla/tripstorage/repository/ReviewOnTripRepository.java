package com.senla.tripstorage.repository;

import com.senla.tripstorage.model.entity.ReviewOnTrip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewOnTripRepository extends JpaRepository<ReviewOnTrip, Long> {
}
