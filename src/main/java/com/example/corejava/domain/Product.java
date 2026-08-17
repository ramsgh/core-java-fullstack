package com.example.corejava.domain;

import java.math.BigDecimal;

public record Product(Long id, String name, BigDecimal price, int stock) {
    public Product {
        if (id == null || id <= 0) throw new IllegalArgumentException("Id must be positive");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name is required");
        if (price == null || price.signum() <= 0) throw new IllegalArgumentException("Price must be positive");
        if (stock < 0) throw new IllegalArgumentException("Stock cannot be negative");
    }
}
