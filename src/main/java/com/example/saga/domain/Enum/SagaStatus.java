package com.example.saga.domain.Enum;

public enum SagaStatus {
    STARTED,
    WAITING_FOR_STOCK,
    WAITING_FOR_PAYMENT,
    WAITING_FOR_ORDER_CONFIRMATION,
    COMPENSATING,
    COMPLETED,
    FAILED
}