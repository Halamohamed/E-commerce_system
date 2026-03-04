package se.lexicon.ecommerce_system.DTOs.customerDTO;

import jakarta.validation.constraints.NotBlank;

public record AddressResponse(
        Long id,
        @NotBlank String street, @NotBlank String city, @NotBlank String zipCode
) {
}
