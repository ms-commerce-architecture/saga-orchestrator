package com.example.saga.repository;

import com.example.saga.domain.SagaOutbox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SagaOutboxRepository extends JpaRepository<SagaOutbox, String> {
}
