package se.lexicon.ecommerce_system.service;

import se.lexicon.ecommerce_system.DTOs.customerDTO.CustomerRequest;
import se.lexicon.ecommerce_system.DTOs.customerDTO.CustomerResponse;

public interface CustomerService {

    public CustomerResponse register(CustomerRequest request);
    public CustomerResponse findById(Long id);
    public CustomerResponse update(Long id,CustomerRequest request);
}
