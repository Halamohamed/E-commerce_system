package se.lexicon.ecommerce_system.service.impl;

import se.lexicon.ecommerce_system.DTOs.customerDTO.CustomerRequest;
import se.lexicon.ecommerce_system.DTOs.customerDTO.CustomerResponse;
import se.lexicon.ecommerce_system.mapper.CustomerMapper;
import se.lexicon.ecommerce_system.repositories.CustomerRepository;
import se.lexicon.ecommerce_system.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponse register(CustomerRequest request) {
        return null;
    }

    @Override
    public CustomerResponse findById(Long id) {
        return null;
    }

    @Override
    public CustomerResponse update(Long id, CustomerRequest request) {
        return null;
    }
}
