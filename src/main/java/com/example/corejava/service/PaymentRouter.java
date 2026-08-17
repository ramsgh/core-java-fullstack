package com.example.corejava.service;
import com.example.corejava.domain.Payment;
public final class PaymentRouter { public boolean processPayment(Payment payment){return payment.authorize();} }
