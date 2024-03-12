package com.murli.order.service;

import com.murli.order.feign.ProductFeignClient;
import com.murli.order.model.Order;
import com.murli.order.model.OrderItem;
import com.murli.order.model.Product;
import com.murli.order.repository.OrderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private ProductFeignClient productFeignClient;


  @Override
  public Order createOrder(Order order) {
    List<OrderItem> items = order.getItems();
    for(OrderItem item: items) {
      Long productId = item.getProductId();
      Product product = productFeignClient.getProductById(productId);
      item.setProductName(product.getName());
      item.setProductPrice(product.getPrice());
    }
    return orderRepository.save(order);
  }

  @Override
  public Order getOrderById(Long orderId) {
    return orderRepository.findById(orderId)
        .orElseThrow(() -> new RuntimeException("Order not found with id : " + orderId));
  }
}
