package com.senla.tripstorage.repository;

import com.senla.tripstorage.model.entity.EventGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventGroupRepository extends JpaRepository<EventGroup, Long> {
    EventGroup findByUuid(String uuid);
    void deleteByUuid(String uuid);
}
