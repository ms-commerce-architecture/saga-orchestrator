package com.example.saga.messaging.command;

import java.math.BigDecimal;

public  record  ProcessPaymentCommand(String commandId, String sagaId, String orderNumber, String customerId, BigDecimal amount, String currency , String idempotencyKey ) {}
