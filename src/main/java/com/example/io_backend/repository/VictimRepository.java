package com.example.io_backend.repository;

import com.example.io_backend.model.Victim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VictimRepository extends JpaRepository<Victim, Long> {
}
