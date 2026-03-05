package se.lexicon.ecommerce_system.service;

import se.lexicon.ecommerce_system.DTOs.productDTO.ProductRequest;
import se.lexicon.ecommerce_system.DTOs.productDTO.ProductResponse;
import se.lexicon.ecommerce_system.exceptions.ResourceNotFoundException;

import java.util.List;

public interface ProductService {

    public ProductResponse create(ProductRequest request) throws ResourceNotFoundException;
    public List<ProductResponse> findAll();
    public List<ProductResponse> searchByName(String name);

}
