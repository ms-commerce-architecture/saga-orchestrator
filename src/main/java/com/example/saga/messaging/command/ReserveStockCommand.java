package com.example.saga.messaging.command;

import com.example.saga.messaging.dto.OrderLine;

import java.util.List;

public record ReserveStockCommand(String commandId, String sagaId, String orderNumber, List<OrderLine> items) {}
