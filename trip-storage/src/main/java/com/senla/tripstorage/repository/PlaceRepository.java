package com.senla.tripstorage.repository;

import com.senla.tripstorage.model.entity.Place;
import org.springframework.data.repository.CrudRepository;

public interface PlaceRepository extends CrudRepository<Place, Long> {
}
