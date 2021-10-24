package com.senla.tripstorage.repository;

import com.senla.tripstorage.model.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
