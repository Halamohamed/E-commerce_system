package se.lexicon.ecommerce_system.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.ecommerce_system.DTOs.customerDTO.CustomerRequest;
import se.lexicon.ecommerce_system.DTOs.customerDTO.CustomerResponse;
import se.lexicon.ecommerce_system.exceptions.EmailAlreadyExistsException;
import se.lexicon.ecommerce_system.exceptions.ResourceNotFoundException;
import se.lexicon.ecommerce_system.service.CustomerService;
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> register(@RequestBody @Valid CustomerRequest customerRequest) throws EmailAlreadyExistsException {
        CustomerResponse customerResponse = customerService.register(customerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> update(@PathVariable Long id, @Valid @RequestBody CustomerRequest customerRequest) throws ResourceNotFoundException {
        return ResponseEntity.ok(customerService.update(id,customerRequest));
    }
}
