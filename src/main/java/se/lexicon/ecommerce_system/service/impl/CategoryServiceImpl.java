package se.lexicon.ecommerce_system.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.ecommerce_system.DTOs.categoryDTO.CategoryResponse;
import se.lexicon.ecommerce_system.entities.Category;
import se.lexicon.ecommerce_system.exceptions.DuplicateKeyException;
import se.lexicon.ecommerce_system.mapper.ProductMapper;
import se.lexicon.ecommerce_system.repositories.CategoryRepository;
import se.lexicon.ecommerce_system.service.CategoryService;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private ProductMapper productMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ProductMapper productMapper) {
        this.categoryRepository = categoryRepository;
        this.productMapper = productMapper;
    }

    @Override
    @Transactional
    public CategoryResponse create(String name) throws DuplicateKeyException {
        if(categoryRepository.existsByNameIgnoreCase(name)){
            throw new DuplicateKeyException("Category with name " + name + " already exists");
        }
        Category category = new Category();
        category.setName(name);
        Category savedCategory = categoryRepository.save(category);
        return new CategoryResponse(savedCategory.getId(), savedCategory.getName());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryResponse> findAll() {
        return categoryRepository.findAll().stream()
                .map(category -> new CategoryResponse(category.getId(),category.getName()) )
                .toList();
    }
}
