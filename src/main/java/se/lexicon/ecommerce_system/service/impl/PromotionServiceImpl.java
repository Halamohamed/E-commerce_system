package se.lexicon.ecommerce_system.service.impl;

import se.lexicon.ecommerce_system.entities.Product;
import se.lexicon.ecommerce_system.entities.Promotion;
import se.lexicon.ecommerce_system.repositories.PromotionRepository;
import se.lexicon.ecommerce_system.service.PromotionService;

import java.time.LocalDateTime;
import java.util.List;

public class PromotionServiceImpl implements PromotionService {
    private PromotionRepository promotionRepository;

    public PromotionServiceImpl(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @Override
    public List<Promotion> getActivePromotions() {
        LocalDateTime today = LocalDateTime.now();
        return promotionRepository.findByStartDateBeforeAndEndDateAfter(today, today);
    }

    @Override
    public double calculateDiscount(Product product) {
        List<Promotion> activePromotions = getActivePromotions();
        /*activePromotions.stream()
                .filter(promotion -> promotion.s(product)
                        .mapToDouble(promotion -> promotion.get);*/

        return 0;   }
}
