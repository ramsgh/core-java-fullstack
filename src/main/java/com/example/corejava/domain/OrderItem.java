package com.example.corejava.domain;

import java.math.BigDecimal;

public record OrderItem(Product product, int quantity) {
    public OrderItem {
        if (product == null) throw new IllegalArgumentException("Product is required");
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be positive");
    }

    public BigDecimal lineTotal() {
        return product.price().multiply(BigDecimal.valueOf(quantity));
    }
}
