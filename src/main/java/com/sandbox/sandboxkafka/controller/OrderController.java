package com.sandbox.sandboxkafka.controller;

import com.sandbox.sandboxkafka.model.Order;
import com.sandbox.sandboxkafka.producer.OrderProducer;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@Log
public class OrderController {

    private final OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping
    public void send(@RequestBody Order order){
        log.info("enviando mensgaem para a fila...");
        orderProducer.send(order);
    }
}
