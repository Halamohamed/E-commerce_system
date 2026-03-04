package se.lexicon.ecommerce_system.DTOs.productDTO;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record ProductRequest(@NotBlank String productName, @NotBlank BigDecimal price, @NotBlank Long categoryId) {
}
