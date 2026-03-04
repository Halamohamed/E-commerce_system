package se.lexicon.ecommerce_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.ecommerce_system.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Optional<Customer> findByEmailIgnoreCase(String email);
    List<Customer> findByLastNameIgnoreCase(String lastName);
    List<Customer> findByAddress_City(String city);
    List<Customer> findByFirstName(String firstName);


}
