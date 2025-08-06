package com.example.product_service.dto;

import java.math.BigInteger;

public record ProductResponse(String name, String description, BigInteger price) {
}
