package com.example.saga.messaging.command;




public record  ConfirmOrderCommand(String commandId,String sagaId,String orderNumber){}
