package com.example.saga.messaging.dto;


import java.math.BigDecimal;
import java.util.List;

public record StartSagaRequest(String orderNumber , String customerId, String email , BigDecimal amount , String currency ,
                               List<OrderLine> items) {}