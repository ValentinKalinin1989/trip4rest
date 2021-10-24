package com.senla.tripstorage.repository;

import com.senla.tripstorage.model.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
