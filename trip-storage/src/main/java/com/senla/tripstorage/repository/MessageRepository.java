package com.senla.tripstorage.repository;

import com.senla.tripstorage.model.entity.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
}
