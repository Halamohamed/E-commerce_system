package se.lexicon.ecommerce_system.repositories;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import se.lexicon.ecommerce_system.entities.Order;
import se.lexicon.ecommerce_system.entities.OrderStatus;

import java.util.List;

public interface OrderRepository extends JpaRepositoryImplementation<Order,Long> {
    List<Order> findByCustomer_Id(Long customerId);
    List<Order> findByStatus(OrderStatus status);
}
