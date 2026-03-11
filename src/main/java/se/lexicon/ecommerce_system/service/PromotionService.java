package se.lexicon.ecommerce_system.service;

import se.lexicon.ecommerce_system.entities.Product;
import se.lexicon.ecommerce_system.entities.Promotion;

import java.util.List;

public interface PromotionService {
    List<Promotion> getActivePromotions();
    double calculateDiscount(Product product);
}
