package se.lexicon.ecommerce_system.service;

import se.lexicon.ecommerce_system.DTOs.categoryDTO.CategoryResponse;
import se.lexicon.ecommerce_system.exceptions.DuplicateKeyException;

import java.util.List;

public interface CategoryService {
    CategoryResponse create(String name) throws DuplicateKeyException;
    List<CategoryResponse> findAll();
}
