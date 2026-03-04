package se.lexicon.ecommerce_system.DTOs.customerDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import se.lexicon.ecommerce_system.mapper.CustomerMapper;

public record CustomerResponse(@NotBlank Long customerId, @NotBlank String  fullName,
                               @Email String email, String addressResponse) {




}
