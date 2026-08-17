package com.example.corejava.service;
import java.math.BigDecimal;
public final class PriceCalculator { public BigDecimal total(BigDecimal price,int quantity){ if(quantity<0)throw new IllegalArgumentException("Quantity cannot be negative"); BigDecimal subtotal=price.multiply(BigDecimal.valueOf(quantity)); return quantity>=10?subtotal.multiply(new BigDecimal("0.90")):subtotal; } public BigDecimal tax(BigDecimal subtotal){return subtotal.multiply(new BigDecimal("0.05"));} }
