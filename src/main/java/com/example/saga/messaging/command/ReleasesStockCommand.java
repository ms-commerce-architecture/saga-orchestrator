package com.example.saga.messaging.command;

public record ReleasesStockCommand(String commandId,String sagaId,String orderNumber,String reason) {}
