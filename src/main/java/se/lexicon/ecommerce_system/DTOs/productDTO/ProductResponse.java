package se.lexicon.ecommerce_system.DTOs.productDTO;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record ProductResponse(@NotBlank String categoryName, @NotBlank String productName, @NotBlank BigDecimal price, @NotBlank Long categoryId) {
}
