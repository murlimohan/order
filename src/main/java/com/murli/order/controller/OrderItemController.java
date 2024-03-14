package com.murli.order.controller;

import com.murli.order.model.OrderItem;
import com.murli.order.service.OrderItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order-items")
public class OrderItemController {

  @Autowired
  private OrderItemService orderItemService;

  @GetMapping("/order/{orderId}")
  public ResponseEntity<List<OrderItem>> getOrderItemsByOrderId(
      @PathVariable("orderId") Long orderId) {
    List<OrderItem> orderItems = orderItemService.getOrderItemsByOrderId(orderId);
    return ResponseEntity.ok(orderItems);
  }

}
