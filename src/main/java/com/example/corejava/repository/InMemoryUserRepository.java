package com.example.corejava.repository;
import com.example.corejava.domain.Customer;
import java.util.*;
public final class InMemoryUserRepository implements UserRepository { private final Map<Long,Customer> db=new HashMap<>(); public void save(Customer u){db.put(u.id(),u);} public Optional<Customer> findById(Long id){return Optional.ofNullable(db.get(id));} public List<Customer> findAll(){return List.copyOf(db.values());} }
