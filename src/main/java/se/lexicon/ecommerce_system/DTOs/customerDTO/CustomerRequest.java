package se.lexicon.ecommerce_system.DTOs.customerDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CustomerRequest(
        @NotBlank String firstName, @NotBlank String lastName, @Email String email, @NotBlank @Size(min = 6) String password,
        @NotBlank String street, @NotBlank String city, @NotBlank String zipCode
) {
}
