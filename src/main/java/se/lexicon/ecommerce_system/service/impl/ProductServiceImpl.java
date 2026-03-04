package se.lexicon.ecommerce_system.service.impl;

import se.lexicon.ecommerce_system.DTOs.productDTO.ProductRequest;
import se.lexicon.ecommerce_system.DTOs.productDTO.ProductResponse;
import se.lexicon.ecommerce_system.mapper.ProductMapper;
import se.lexicon.ecommerce_system.repositories.CategoryRepository;
import se.lexicon.ecommerce_system.repositories.CustomerRepository;
import se.lexicon.ecommerce_system.repositories.ProductRepository;
import se.lexicon.ecommerce_system.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductResponse create(ProductRequest request) {
        return null;
    }

    @Override
    public List<ProductResponse> findAll() {
        return List.of();
    }

    @Override
    public List<ProductResponse> searchByName(String name) {
        return List.of();
    }
}
