package com.example.saga.domain;


import com.example.saga.domain.Enum.SagaStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.Instant;


@Entity
@Getter
@NoArgsConstructor
@Table(
        name = "saga_instances",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_saga_order_number",
                        columnNames = "order_number"
                )
        }
)
public class SagaInstance {

    @Id
    @Column(name = "saga_id", nullable = false, length = 36)
    private String sagaId;

    @Column(name = "order_number",
            nullable = false,
            unique = true,
            length = 100)
    private String orderNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "saga_status", nullable = false, length = 40)
    private SagaStatus status;

    @Column(name = "current_step", length = 100)
    private String currentStep;


    @Column(name = "request_payload", columnDefinition = "JSON")
    private String requestPayload;
    @Column(name = "failure_reason",length = 1000)
    private String failureReason;

    @Version
    @Column(nullable = false)
    private Long version;
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;



    public SagaInstance(String sagaId, String orderNumber) {
        this.sagaId = sagaId;
        this.orderNumber = orderNumber;
        this.status = SagaStatus.STARTED;
        this.currentStep = "START";
        this.createdAt = Instant.now();
        this.updatedAt = this.createdAt;
    }

    public void transitionTo(
            SagaStatus status,
            String currentStep) {

        this.status = status;
        this.currentStep = currentStep;
        this.updatedAt = Instant.now();
    }
}