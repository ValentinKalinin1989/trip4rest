package com.senla.tripstorage.repository;

import com.senla.tripstorage.model.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}
