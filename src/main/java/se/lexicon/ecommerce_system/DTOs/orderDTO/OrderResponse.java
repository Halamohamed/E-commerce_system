package se.lexicon.ecommerce_system.DTOs.orderDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;

public record OrderResponse(@NotNull Long orderId, @NotNull String orderStatus, List<OrderItemsResponse> orderItems)  {

    public record OrderItemsResponse(@NotBlank String productName, @NotBlank BigDecimal price, @NotBlank Long categoryId) {

    }
}
