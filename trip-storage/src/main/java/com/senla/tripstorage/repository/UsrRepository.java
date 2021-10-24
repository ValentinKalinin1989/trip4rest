package com.senla.tripstorage.repository;

import com.senla.tripstorage.model.entity.Usr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsrRepository extends JpaRepository<Usr, Long> {
}
