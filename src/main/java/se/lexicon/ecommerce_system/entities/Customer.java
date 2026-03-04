package se.lexicon.ecommerce_system.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true) //safe equals/hashCode
@ToString(exclude = "userProfile")
@Builder
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
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "profile_id")
    //@ToString.Exclude
    private UserProfile userProfile;

    public void setProfile(UserProfile userProfile) {
        if(this.userProfile == null) {
            this.userProfile.setCustomer(null);
        }
        this.userProfile = userProfile;
        if(this.userProfile != null) {
            userProfile.setCustomer(this);
        }
    }
    @PrePersist
    private void prePersist() {
        createAt = Instant.now();
    }

}
