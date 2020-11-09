package com.sandbox.sandboxkafka.model;

import lombok.Data;

@Data
public class Order {
    private String description;
    private double value;
}
