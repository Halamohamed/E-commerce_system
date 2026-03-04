package se.lexicon.ecommerce_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.ecommerce_system.entities.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByCategory_NameIgnoreCase(String categoryName);
    List<Product> findByPriceBetween(BigDecimal priceStart, BigDecimal priceEnd);
    List<Product> findByNameContainingIgnoreCase(String keyword);
    List<Product> findByPriceLessThan(BigDecimal max);
    List<Product> findByCategory_Id(Long categoryId);
    long countByCategory_NameIgnoreCase(String categoryName);

}
