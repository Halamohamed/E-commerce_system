package se.lexicon.ecommerce_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.ecommerce_system.entities.Address;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {
    List<Address> findByZipCode(String zipcode);
}
