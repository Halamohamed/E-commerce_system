package se.lexicon.ecommerce_system.service.impl;

import org.springframework.stereotype.Service;
import se.lexicon.ecommerce_system.DTOs.orderDTO.OrderRequest;
import se.lexicon.ecommerce_system.DTOs.orderDTO.OrderResponse;
import se.lexicon.ecommerce_system.entities.Customer;
import se.lexicon.ecommerce_system.entities.Order;
import se.lexicon.ecommerce_system.entities.OrderItem;
import se.lexicon.ecommerce_system.entities.Product;
import se.lexicon.ecommerce_system.exceptions.ResourceNotFoundException;
import se.lexicon.ecommerce_system.mapper.OrderMapper;
import se.lexicon.ecommerce_system.repositories.CustomerRepository;
import se.lexicon.ecommerce_system.repositories.OrderRepository;
import se.lexicon.ecommerce_system.repositories.ProductRepository;
import se.lexicon.ecommerce_system.service.OrderService;

import java.util.ArrayList;
import java.util.List;

@Service
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
    public OrderResponse placeOrder(OrderRequest request) throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(request.custerId()).orElseThrow(() -> new ResourceNotFoundException("Customer not found: " + request.custerId()));
        List<OrderItem> items = new ArrayList<>();
        for(OrderRequest.OrderItemsRequest itemsRequest : request.orderItemsResponses()){
            Product product = productRepository.findById(itemsRequest.productId()).orElseThrow(() -> new ResourceNotFoundException("Product not found: " + itemsRequest.productId()));
            OrderItem item = new OrderItem();
            item.setProduct(product);
            item.setQuantity(itemsRequest.quantity());
            item.setPriceAtPurchase(product.getPrice());
            items.add(item);
        }
        Order order = orderMapper.toEntity(request, customer, items);
        Order savedOrder = orderRepository.save(order);
        return orderMapper.toResponse(savedOrder);
    }
}
