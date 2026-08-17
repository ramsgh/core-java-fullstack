package com.example.corejava.service;
import com.example.corejava.domain.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
public final class AnalyticsService {
 public List<Product> filter(List<Product> products, Predicate<Product> condition){return products.stream().filter(condition).toList();}
 public Map<Long,Integer> unitsByProduct(List<Order> orders){return orders.stream().flatMap(o->o.items().stream()).collect(Collectors.groupingBy(i->i.product().id(),Collectors.summingInt(OrderItem::quantity)));}
 public BigDecimal revenue(List<Order> orders){return orders.stream().map(Order::total).reduce(BigDecimal.ZERO,BigDecimal::add);}
 public Optional<Product> mostExpensive(List<Product> products){return products.stream().max(Comparator.comparing(Product::price));}
}
