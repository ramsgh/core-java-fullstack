package com.example.corejava.domain;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public record Order(Long id, Long customerId, List<OrderItem> items, OrderStatus status, Instant createdAt) {
    public Order {
        if (id == null || customerId == null) throw new IllegalArgumentException("Order and customer ids are required");
        if (items == null || items.isEmpty()) throw new IllegalArgumentException("Order needs items");
        items = List.copyOf(items);
        if (status == null) status = OrderStatus.PENDING;
        if (createdAt == null) createdAt = Instant.now();
    }

    public BigDecimal total() {
        return items.stream().map(OrderItem::lineTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Order withStatus(OrderStatus newStatus) {
        return new Order(id, customerId, items, newStatus, createdAt);
    }
}
