package com.example.saga.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
@Entity
@Getter
@NoArgsConstructor
@Table(name = "saga_processed_messages")
public class ProcessedMessage {

    @Id
    @Column(name = "message_id", nullable = false, length = 160)
    private String messageId;

    @Column(name = "processed_at", nullable = false)
    private Instant processedAt;

    public ProcessedMessage(String messageId) {
        this.messageId = messageId;
        this.processedAt = Instant.now();
    }
}