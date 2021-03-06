package com.senla.tripstorage.repository;

import com.senla.tripstorage.model.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    Place findByUuid(String uuid);
    void deleteByUuid(String uuid);
}
