package com.example.saga.messaging.event;

public record SagaEvent(String eventId,String sagaId,String orderNumber,String type,String reason) {}
