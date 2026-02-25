package se.lexicon.ecommerce_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.ecommerce_system.entities.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByName(String categoryName);
}
