package com.senla.tripstorage.repository;

import com.senla.tripstorage.model.entity.EventType;
import org.springframework.data.repository.CrudRepository;

public interface EventTypeRepository extends CrudRepository<EventType, Long> {
}
