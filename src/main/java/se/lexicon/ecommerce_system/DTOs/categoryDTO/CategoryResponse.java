package se.lexicon.ecommerce_system.DTOs.categoryDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CategoryResponse(@NotNull Long id, @NotBlank String name) {

}
