package se.lexicon.ecommerce_system.service.impl;

import se.lexicon.ecommerce_system.DTOs.orderDTO.OrderRequest;
import se.lexicon.ecommerce_system.DTOs.orderDTO.OrderResponse;
import se.lexicon.ecommerce_system.mapper.OrderMapper;
import se.lexicon.ecommerce_system.repositories.CustomerRepository;
import se.lexicon.ecommerce_system.repositories.OrderRepository;
import se.lexicon.ecommerce_system.repositories.ProductRepository;
import se.lexicon.ecommerce_system.service.OrderService;

public class OrderServiceImpl implements OrderService {

    private CustomerRepository customerRepository;
    private OrderRepository orderRepository;
    private ProductRepository productRepository;
    private OrderMapper orderMapper;

    public OrderServiceImpl(CustomerRepository customerRepository, OrderRepository orderRepository, ProductRepository productRepository, OrderMapper orderMapper) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public OrderResponse placeOrder(OrderRequest request) {
        return null;
    }
}
