package se.lexicon.ecommerce_system.service;

import se.lexicon.ecommerce_system.DTOs.orderDTO.OrderRequest;
import se.lexicon.ecommerce_system.DTOs.orderDTO.OrderResponse;

public interface OrderService {

    public OrderResponse placeOrder(OrderRequest request);
}
