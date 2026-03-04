package se.lexicon.ecommerce_system.mapper;

import se.lexicon.ecommerce_system.DTOs.productDTO.ProductRequest;
import se.lexicon.ecommerce_system.DTOs.productDTO.ProductResponse;
import se.lexicon.ecommerce_system.entities.Category;
import se.lexicon.ecommerce_system.entities.Product;

public class ProductMapper {

    public ProductResponse toResponse(Product  product) {
        return new ProductResponse(
                product.getId(),
                product.getCategory().getName(),
                product.getName(),
                product.getPrice()
        );
    }

    public Product toEntity(ProductRequest request, Category category) {
        Product product = new Product();
        product.setName(request.productName());
        product.setPrice(request.price());
        product.setCategory(category);
        return product;
    }
}
