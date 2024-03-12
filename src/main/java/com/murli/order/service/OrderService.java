package com.murli.order.service;

import com.murli.order.model.Order;

public interface OrderService {

  Order createOrder(Order order);

  Order getOrderById(Long orderId);

}
