package com.example.product_service.dto;

import java.math.BigInteger;

public record ProductRequest(String id,
        String name,
        String description,
        BigInteger price) {
}
