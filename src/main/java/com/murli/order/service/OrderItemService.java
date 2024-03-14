package com.murli.order.service;

import com.murli.order.model.OrderItem;
import java.util.List;

public interface OrderItemService {

  List<OrderItem> getOrderItemsByOrderId(Long orderId);
}
