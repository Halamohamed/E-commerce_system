package se.lexicon.ecommerce_system.mapper;

import org.springframework.stereotype.Component;
import se.lexicon.ecommerce_system.DTOs.customerDTO.AddressResponse;
import se.lexicon.ecommerce_system.DTOs.customerDTO.CustomerRequest;
import se.lexicon.ecommerce_system.DTOs.customerDTO.CustomerResponse;
import se.lexicon.ecommerce_system.entities.Address;
import se.lexicon.ecommerce_system.entities.Customer;
@Component
public class CustomerMapper {

    public CustomerResponse toResponse(Customer entity){

        Address address = entity.getAddress();
        AddressResponse addressResponse = new AddressResponse(address.getId(),
                address.getStreet(), address.getCity(), address.getZipCode());
        String fullName = entity.getFirstName() + " " + entity.getLastName();
        return new CustomerResponse(entity.getId(), fullName, entity.getEmail(),addressResponse);

    }

    public Customer toEntity(CustomerRequest request){
        if(request == null) throw new IllegalArgumentException("request cannot be null");

        Address address = new Address();
        address.setStreet(request.street());
        address.setCity(request.city());
        address.setZipCode(request.zipCode());

        Customer entity = new Customer();
        entity.setFirstName(request.firstName());
        entity.setLastName(request.lastName());
        entity.setEmail(request.email());
        entity.setAddress(address);

        return entity;
    }

    public void updateEntity(Customer customer, CustomerRequest request) {
        customer.setFirstName(request.firstName());
        customer.setLastName(request.lastName());
        customer.setEmail(request.email());
        customer.getAddress().setStreet(request.street());
        customer.getAddress().setCity(request.city());
        customer.getAddress().setZipCode(request.zipCode());
    }
}
