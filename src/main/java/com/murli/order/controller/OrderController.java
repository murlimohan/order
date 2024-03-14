package com.murli.order.controller;

import com.murli.order.model.Order;
import com.murli.order.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

  @Autowired
  private OrderService orderService;

  @PostMapping
  public ResponseEntity<Order> createOrder(@RequestBody Order order) {
    Order newOrder = orderService.createOrder(order);
    return ResponseEntity.status(HttpStatus.CREATED).body(newOrder);
  }

  @GetMapping("/{orderId}")
  public ResponseEntity<Order> getOrderById(@PathVariable("orderId") Long orderId) {
    Order order = orderService.getOrderById(orderId);
    return ResponseEntity.ok(order);
  }

  @GetMapping
  public ResponseEntity<List<Order>> getAllOrders() {
    List<Order> orders = orderService.getAllOrders();
    return ResponseEntity.ok(orders);
  }

  @PutMapping("/{orderId}")
  public ResponseEntity<Order> updateOrder(@PathVariable("orderId") Long orderId,
      @RequestBody Order order) {
    Order updatedOrder = orderService.updateOrder(orderId, order);
    return ResponseEntity.ok(updatedOrder);
  }

  @DeleteMapping("/{orderId}")
  public ResponseEntity<Void> deleteOrder(@PathVariable("orderId") Long orderId) {
    orderService.deleteOrder(orderId);
    return ResponseEntity.noContent().build();
  }
}
