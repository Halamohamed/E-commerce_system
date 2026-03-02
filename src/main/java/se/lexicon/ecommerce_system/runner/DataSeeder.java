package se.lexicon.ecommerce_system.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.ecommerce_system.entities.*;
import se.lexicon.ecommerce_system.repositories.CategoryRepository;
import se.lexicon.ecommerce_system.repositories.CustomerRepository;
import se.lexicon.ecommerce_system.repositories.ProductRepository;
import se.lexicon.ecommerce_system.repositories.PromotionRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@Component
public class DataSeeder implements CommandLineRunner {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private PromotionRepository promotionRepository;
    private CustomerRepository customerRepository;

    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository, PromotionRepository promotionRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.promotionRepository = promotionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        IO.println("Welcome to E-Commerce System");
        UserProfile userProfile1 = UserProfile.builder()
                .nickname("Hala Ali")
                .phoneNumber("07456123")
                .bio("Fullstack student")
                .build();

        Address address1 = Address.builder()
                .city("Karlshamn")
                .street("Street 12")
                .zipCode("1223")
                .build();

        Customer customer1 = Customer.builder()
                .firstName("Hala")
                .lastName("Ali")
                .email("hala@example.se")
                .address(address1)
                .userProfile(userProfile1).build();
        UserProfile userProfile2 = UserProfile.builder()
                .nickname("Maha Hamid")
                .phoneNumber("07456156")
                .bio("Java developer student")
                .build();

        Address address2 = Address.builder()
                .city("Växjö")
                .street("Street 33")
                .zipCode("1423")
                .build();

        Customer customer2 = Customer.builder()
                .firstName("Maha")
                .lastName("Hamid")
                .email("maha@example.se")
                .address(address2)
                .userProfile(userProfile2).build();
        if (categoryRepository.count() == 0) {
            Category electronics = new Category();
            electronics.setName("Electronics");

            Category books = new Category();
            books.setName("Books");

            categoryRepository.saveAll(List.of(electronics, books));

            Product laptop = new Product();
            laptop.setName("Laptop");
            laptop.setPrice(new BigDecimal("999.99"));
            laptop.setCategory(electronics);

            Product javaBook = new Product();
            javaBook.setName("Java Book");
            javaBook.setPrice(new BigDecimal("39.99"));
            javaBook.setCategory(books);

            productRepository.saveAll(List.of(laptop, javaBook));

            //productRepository.findByName(laptop.getName()).forEach(System.out::println);
            Order order = new Order();
            order.setStatus(OrderStatus.CREATED);
            order.setCustomer(customer2);
            order.prePersist();


            Promotion winter = new Promotion();
            winter.setCode("WINTER25");
            winter.setStartDate(LocalDateTime.of(2025,11,1,0,0));
            winter.setEndDate(LocalDateTime.of(2026,2,28,0,0));

            promotionRepository.save(winter);
            laptop.getPromotions().add(winter);
            productRepository.save(laptop);


        }
    }
}
