package com.example.corejava.capstone;
import com.example.corejava.domain.Product;
import com.example.corejava.exceptions.InsufficientBalanceException;
import java.util.concurrent.ConcurrentHashMap;
public final class InventoryManager { private final ConcurrentHashMap<Long,Integer> stock=new ConcurrentHashMap<>(); public void add(Product p){stock.put(p.id(),p.stock());} public synchronized void deduct(Product p,int qty){int current=stock.getOrDefault(p.id(),0);if(current<qty)throw new InsufficientBalanceException("Out of stock: "+p.name());stock.put(p.id(),current-qty);} public int remaining(Long id){return stock.getOrDefault(id,0);} }
