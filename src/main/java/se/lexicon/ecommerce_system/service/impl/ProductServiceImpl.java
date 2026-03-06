package se.lexicon.ecommerce_system.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.ecommerce_system.DTOs.productDTO.ProductRequest;
import se.lexicon.ecommerce_system.DTOs.productDTO.ProductResponse;
import se.lexicon.ecommerce_system.entities.Category;
import se.lexicon.ecommerce_system.entities.Product;
import se.lexicon.ecommerce_system.exceptions.ResourceNotFoundException;
import se.lexicon.ecommerce_system.mapper.ProductMapper;
import se.lexicon.ecommerce_system.repositories.CategoryRepository;
import se.lexicon.ecommerce_system.repositories.ProductRepository;
import se.lexicon.ecommerce_system.service.ProductService;

import java.util.List;
@Service
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
    @Transactional
    public ProductResponse create(ProductRequest request) throws ResourceNotFoundException {
        Category category = categoryRepository.findById(request.categoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category Not Found"));
        Product product = productMapper.toEntity(request, category);
        Product savedProduct = productRepository.save(product);
        return productMapper.toResponse(savedProduct);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponse> findAll() {
        return productRepository.findAll().stream()
                .map(productMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponse> searchByName(String name) {

        return productRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(productMapper::toResponse)
                .toList();
    }
}
