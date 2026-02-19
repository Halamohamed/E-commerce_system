package se.lexicon.ecommerce_system.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.ecommerce_system.entities.Address;
import se.lexicon.ecommerce_system.entities.Customer;
import se.lexicon.ecommerce_system.entities.UserProfile;
import se.lexicon.ecommerce_system.repositories.AddressRepository;
import se.lexicon.ecommerce_system.repositories.CustomerRepository;
import se.lexicon.ecommerce_system.repositories.UserProfileRepository;
@Component
public class MyCommandLineRunner implements CommandLineRunner {

    private AddressRepository addressRepository;
    private CustomerRepository customerRepository;
    private UserProfileRepository userProfileRepository;

    @Autowired
    public MyCommandLineRunner(AddressRepository addressRepository, CustomerRepository customerRepository, UserProfileRepository userProfileRepository) {
        this.addressRepository = addressRepository;
        this.customerRepository = customerRepository;
        this.userProfileRepository = userProfileRepository;
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

        //addressRepository.save(address);
        customerRepository.save(customer1);
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


        customerRepository.save(customer2);
        customerRepository.findAll().forEach(System.out::println);


    }
}
