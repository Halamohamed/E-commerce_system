package se.lexicon.ecommerce_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.ecommerce_system.entities.Category;

import java.util.List;

public interface CategoryRepository  extends JpaRepository<Category,Long> {

    List<Category> findByName(String categoryName);
    Boolean existsByName(String categoryName);

}
