package com.example.corejava.repository;
import com.example.corejava.domain.Customer;
import java.util.*;
public interface UserRepository { void save(Customer user); Optional<Customer> findById(Long id); List<Customer> findAll(); }
