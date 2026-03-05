package se.lexicon.ecommerce_system.mapper;

import org.springframework.stereotype.Component;
import se.lexicon.ecommerce_system.DTOs.orderDTO.OrderRequest;
import se.lexicon.ecommerce_system.DTOs.orderDTO.OrderResponse;
import se.lexicon.ecommerce_system.entities.Customer;
import se.lexicon.ecommerce_system.entities.Order;
import se.lexicon.ecommerce_system.entities.OrderItem;
import se.lexicon.ecommerce_system.entities.OrderStatus;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
@Component
public class OrderMapper {

    public Order toEntity(OrderRequest orderRequest, Customer customer, List<OrderItem> orderItems) {
        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderDate(Instant.now());
        order.setStatus(OrderStatus.CREATED);
        orderItems.forEach(i -> i.setOrder(order));
        order.setItems(orderItems);
        return order;
    }

    public OrderResponse toResponse(Order order) {
        List<OrderResponse.OrderItemsResponse> orderItems = order.getItems().stream().map(item -> new OrderResponse.OrderItemsResponse(
                item.getProduct().getId(),
                item.getProduct().getName(),
                item.getQuantity(),
                item.getPriceAtPurchase()
        )).toList();
        return new OrderResponse(
                order.getId(),
                order.getOrderDate(),
                order.getStatus().name(),
                order.getCustomer().getId(),
                orderItems
        );

    }
}
