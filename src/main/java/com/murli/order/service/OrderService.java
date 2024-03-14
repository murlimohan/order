package com.murli.order.service;

import com.murli.order.model.Order;
import java.util.List;

public interface OrderService {

  Order createOrder(Order order);

  Order getOrderById(Long orderId);

  List<Order> getAllOrders();

  Order updateOrder(Long orderId, Order order);

  void deleteOrder(Long orderId);
}
