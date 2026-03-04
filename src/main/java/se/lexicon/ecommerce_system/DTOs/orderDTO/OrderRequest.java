package se.lexicon.ecommerce_system.DTOs.orderDTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import se.lexicon.ecommerce_system.entities.OrderStatus;

import java.math.BigDecimal;
import java.util.List;

public record OrderRequest(
        @NotBlank Long custerId, @NotBlank OrderStatus orderStatus,
        List<OrderItemsRequest> orderItemsResponses
        ) {

        public record OrderItemsRequest(@NotNull Long productId, @NotNull @Min(value = 1, message = "quantity must not be null") Integer quantity) {


        }
}
