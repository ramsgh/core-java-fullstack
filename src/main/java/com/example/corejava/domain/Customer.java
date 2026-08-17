package com.example.corejava.domain;

public record Customer(Long id, String email) {
    public Customer {
        if (id == null || id <= 0) throw new IllegalArgumentException("Id must be positive");
        if (email == null || !email.contains("@")) throw new IllegalArgumentException("Valid email is required");
    }
}
