package se.lexicon.ecommerce_system.DTOs.productDTO;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRequest(@NotBlank String productName,
                             @NotNull @DecimalMin("0.0") BigDecimal price,
                             @NotNull Long categoryId) {
}
