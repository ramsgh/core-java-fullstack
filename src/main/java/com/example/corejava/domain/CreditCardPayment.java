package com.example.corejava.domain;

import java.math.BigDecimal;

public final class CreditCardPayment extends Payment {
    private final String maskedCard;
    public CreditCardPayment(BigDecimal amount, String maskedCard) { super(amount, "USD"); this.maskedCard = maskedCard; }
    @Override public boolean authorize() { return maskedCard != null && maskedCard.length() >= 4; }
}
