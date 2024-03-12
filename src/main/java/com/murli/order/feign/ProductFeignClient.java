package com.murli.order.feign;

import com.murli.order.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service")
public interface ProductFeignClient {

  @GetMapping("/api/products/{productId}")
  Product getProductById(@PathVariable("productId") Long productId);

}
