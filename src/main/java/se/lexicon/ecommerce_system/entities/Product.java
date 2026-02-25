package se.lexicon.ecommerce_system.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 150)
    private String name;

    private List<String> imageUrls;
    @Column(nullable = false)
    private BigDecimal price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
}
