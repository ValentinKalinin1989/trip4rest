package com.senla.tripstorage.repository;

import com.senla.tripstorage.model.entity.Chat;
import org.springframework.data.repository.CrudRepository;

public interface ChatRepository extends CrudRepository<Chat, Long> {
}
