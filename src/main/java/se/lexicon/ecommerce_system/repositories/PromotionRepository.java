package se.lexicon.ecommerce_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import se.lexicon.ecommerce_system.entities.Promotion;

import java.lang.classfile.constantpool.LoadableConstantEntry;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    @Query("""
    SELECT p FROM Promotion p 
    WHERE p.startDate <= :date
    AND(p.endDate is null or p.endDate >= :date)
""")
    List<Promotion> findActiveOn(LocalDateTime date);


    Optional<Promotion> findByCode(String code);

    List<Promotion> findByStartDateAfter(LocalDateTime date);

    List<Promotion> findByStartDateBefore(LocalDateTime date);

    List<Promotion> findByEndDateIsNull(LocalDateTime date);
    List<Promotion> findByEndDateAfter(LocalDateTime date);
    default List<Promotion> findActiveToday(){
        return findActiveOn(LocalDateTime.now());
    }
}
