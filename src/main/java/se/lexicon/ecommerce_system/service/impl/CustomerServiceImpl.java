package se.lexicon.ecommerce_system.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.ecommerce_system.DTOs.customerDTO.CustomerRequest;
import se.lexicon.ecommerce_system.DTOs.customerDTO.CustomerResponse;
import se.lexicon.ecommerce_system.entities.Customer;
import se.lexicon.ecommerce_system.exceptions.EmailAlreadyExistsException;
import se.lexicon.ecommerce_system.exceptions.ResourceNotFoundException;
import se.lexicon.ecommerce_system.mapper.CustomerMapper;
import se.lexicon.ecommerce_system.repositories.CustomerRepository;
import se.lexicon.ecommerce_system.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    @Transactional
    public CustomerResponse register(CustomerRequest request) throws EmailAlreadyExistsException {
        if(customerRepository.existsByEmailIgnoreCase(request.email())){
            throw new EmailAlreadyExistsException("Email already in use: " + request.email());
        }
        Customer customer = customerMapper.toEntity(request);
        Customer savedCustomer = customerRepository.save(customer);

        return customerMapper.toResponse(savedCustomer);
    }

    @Override
    @Transactional(readOnly = true)
    public CustomerResponse findById(Long id) throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found:  " + id));
        return customerMapper.toResponse(customer);
    }

    @Override
    @Transactional
    public CustomerResponse update(Long id, CustomerRequest request) throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found:  " + id));
        customerMapper.updateEntity(customer, request);
        Customer updatedCustomer = customerRepository.save(customer);

        return customerMapper.toResponse(updatedCustomer);
    }
}
