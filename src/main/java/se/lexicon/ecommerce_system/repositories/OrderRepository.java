package se.lexicon.ecommerce_system.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;
import se.lexicon.ecommerce_system.entities.Order;
import se.lexicon.ecommerce_system.entities.OrderStatus;

import java.util.List;

public interface OrderRepository extends JpaRepositoryImplementation<Order,Long> {
    List<Order> findByCustomer_Id(Long customerId);

    @Query("select distinct o from Order o left join fetch o.items where o.status = :status")
    List<Order> findByStatusWithItems(@Param("status") OrderStatus status);
}
