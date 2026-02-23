package se.lexicon.ecommerce_system.entities;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "customer")
@Builder
@Entity
@Table(name = "user_profiles")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String nickname;
    @Column(nullable = false, length = 100)
    private String phoneNumber;
    @Column(length = 500)
    private String bio;

    @OneToOne(mappedBy = "userProfile")
    private Customer customer;
}
