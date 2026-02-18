package se.lexicon.ecommerce_system.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(nullable = false, length = 100)
    private String lastName;

    @Column(nullable = false,unique = true, length = 150)
    private String email;

    @Column(nullable = false, updatable = false)
    private Instant createAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false,name = "address_id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "profile_id")
    private UserProfile userProfile;

    @PrePersist
    private void prePersist() {
        createAt = Instant.now();
    }

}
