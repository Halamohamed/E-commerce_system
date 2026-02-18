package se.lexicon.ecommerce_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.ecommerce_system.entities.UserProfile;

import java.util.List;
import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile,Long> {

    Optional<UserProfile> findByNickname(String nickname);
    List<UserProfile> findByPhoneNumberContaining(String phoneNumber);

}
