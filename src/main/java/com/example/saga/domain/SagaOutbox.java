package com.example.saga.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "saga_outbox")
public class SagaOutbox {

    @Id
    @Column(nullable = false, length = 36)
    private String id;

    @Column(name = "aggregatetype", nullable = false)
    private String aggregatetype;

    @Column(name = "aggregateid", nullable = false)
    private String aggregateid;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false, columnDefinition = "json")
    private String payload;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    public SagaOutbox(
            String aggregateid,
            String type,
            String payload) {

        this.id = UUID.randomUUID().toString();
        this.aggregatetype = "saga";
        this.aggregateid = aggregateid;
        this.type = type;
        this.payload = payload;
        this.createdAt = Instant.now();
    }
}
