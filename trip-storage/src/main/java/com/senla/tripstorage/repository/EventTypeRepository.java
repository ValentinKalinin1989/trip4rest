package com.senla.tripstorage.repository;

import com.senla.tripstorage.model.entity.EventType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventTypeRepository extends JpaRepository<EventType, Long> {
    void deleteByUuid(String uuid);
}
