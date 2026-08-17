package com.example.corejava.domain;

import java.math.BigDecimal;

public abstract class Payment {
    private final BigDecimal amount;
    private final String currency;

    protected Payment(BigDecimal amount, String currency) {
        if (amount == null || amount.signum() <= 0) throw new IllegalArgumentException("Amount must be positive");
        this.amount = amount;
        this.currency = currency;
    }

    public abstract boolean authorize();
    public BigDecimal amount() { return amount; }
    public String currency() { return currency; }
}
