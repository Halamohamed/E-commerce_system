package se.lexicon.ecommerce_system.service;

import se.lexicon.ecommerce_system.DTOs.customerDTO.CustomerRequest;
import se.lexicon.ecommerce_system.DTOs.customerDTO.CustomerResponse;
import se.lexicon.ecommerce_system.exceptions.ResourceNotFoundException;

public interface CustomerService {

    public CustomerResponse register(CustomerRequest request);
    public CustomerResponse findById(Long id) throws ResourceNotFoundException;
    public CustomerResponse update(Long id,CustomerRequest request) throws ResourceNotFoundException;
}
