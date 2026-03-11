package se.lexicon.ecommerce_system.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.lexicon.ecommerce_system.DTOs.orderDTO.OrderRequest;
import se.lexicon.ecommerce_system.DTOs.orderDTO.OrderResponse;
import se.lexicon.ecommerce_system.exceptions.ResourceNotFoundException;
import se.lexicon.ecommerce_system.service.OrderService;
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> placeOrder(@Valid @RequestBody OrderRequest orderRequest) throws ResourceNotFoundException {
        OrderResponse orderResponse = orderService.placeOrder(orderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderResponse);
    }
}
