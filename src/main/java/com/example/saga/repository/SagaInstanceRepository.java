package com.example.saga.repository;

import com.example.saga.domain.SagaInstance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SagaInstanceRepository extends JpaRepository<SagaInstance, String> {
    Optional<SagaInstance> findByOrderNumber(String orderNumber);
}
