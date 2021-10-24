package com.senla.tripstorage.repository;

import com.senla.tripstorage.model.entity.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
}
