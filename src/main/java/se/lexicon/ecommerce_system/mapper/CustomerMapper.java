package se.lexicon.ecommerce_system.mapper;

import org.springframework.stereotype.Component;
import se.lexicon.ecommerce_system.DTOs.customerDTO.CustomerRequest;
import se.lexicon.ecommerce_system.DTOs.customerDTO.CustomerResponse;
import se.lexicon.ecommerce_system.entities.Customer;
@Component
public class CustomerMapper {

    CustomerResponse toResponse(Customer entity){

        return new CustomerResponse(entity.getId(), entity.getFirstName(), entity.getEmail(),"null");

    }

    Customer toEntity(CustomerRequest request){
        if(request == null) throw new IllegalArgumentException("request cannot be null");

        Customer entity = new Customer();
        entity.setFirstName(request.firstName());
        entity.setLastName(request.lastName());
        entity.setEmail(request.email());

        return entity;
    }
}
