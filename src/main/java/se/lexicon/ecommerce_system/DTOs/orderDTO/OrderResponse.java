package se.lexicon.ecommerce_system.DTOs.orderDTO;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public record OrderResponse(@NotNull Long orderId,
                            @NotNull Instant orderDate,
                            @NotNull String orderStatus,
                            @NotNull Long customerId,
                            List<OrderItemsResponse> orderItems)  {

    public record OrderItemsResponse(@NotNull Long productId,
                                     @NotBlank String productName,
                                     @NotBlank int quantity,
                                     @NotBlank BigDecimal price) {

    }
}
