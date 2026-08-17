package com.example.corejava;
import com.example.corejava.domain.*; import com.example.corejava.service.*; import com.example.corejava.capstone.*; import org.junit.jupiter.api.Test; import java.math.BigDecimal; import java.time.Instant; import java.util.*; import static org.junit.jupiter.api.Assertions.*;
class CoreJavaTest {
 @Test void priceUsesDecimalAndDiscount(){var c=new PriceCalculator();assertEquals(0, new BigDecimal("90.00").compareTo(c.total(new BigDecimal("10.00"),10)));}
 @Test void productRejectsNegativeStock(){assertThrows(IllegalArgumentException.class,()->new Product(1L,"x",BigDecimal.ONE,-1));}
 @Test void streamsGroupAndSum(){var p=new Product(1L,"x",new BigDecimal("2"),5);var o=new Order(1L,1L,List.of(new OrderItem(p,3)),OrderStatus.PENDING,Instant.now());assertEquals(3,new AnalyticsService().unitsByProduct(List.of(o)).get(1L));}
 @Test void synchronizedInventoryPreventsOversell(){var p=new Product(1L,"x",BigDecimal.ONE,1);var i=new InventoryManager();i.add(p);assertDoesNotThrow(()->i.deduct(p,1));assertThrows(RuntimeException.class,()->i.deduct(p,1));}
}
