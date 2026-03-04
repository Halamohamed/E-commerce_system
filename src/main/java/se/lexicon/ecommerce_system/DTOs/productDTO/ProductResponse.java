package se.lexicon.ecommerce_system.DTOs.productDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductResponse(@NotNull Long id,
                              @NotBlank String categoryName,
                              @NotBlank String productName,
                              @NotNull BigDecimal price
                              ) {
}
