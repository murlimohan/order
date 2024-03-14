package com.murli.order.service;

import com.murli.order.model.OrderItem;
import com.murli.order.repository.OrderItemRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl implements OrderItemService{

  @Autowired
  private OrderItemRepository orderItemRepository;

  @Override
  public List<OrderItem> getOrderItemsByOrderId(Long orderId) {
    return orderItemRepository.findByOrderId(orderId);
  }
}
