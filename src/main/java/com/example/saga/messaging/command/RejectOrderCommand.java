package com.example.saga.messaging.command;

public record RejectOrderCommand(String commandId,String sagaId,String orderNumber,String reason) {}
