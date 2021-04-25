package com.ns.springboothibernateenvers;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SpringBootHibernateEnversApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHibernateEnversApplication.class, args);
    }

    @Bean
    ApplicationRunner init(UserDetailsRepository userRepository) {
        return (ApplicationArguments args) -> dataSetup(userRepository);
    }
    private void dataSetup(UserDetailsRepository userRepository) {

        UserDetails userDetails = new UserDetails(1, "NIRAJ", "SONAWANE");

        userRepository.save(userDetails);      // Create

        userDetails.setFirstName("Updated Name");
        userRepository.save(userDetails); // Update-1

        userDetails.setLastName("Updated Last name"); // Update-2
        userRepository.save(userDetails);

        userRepository.delete(userDetails); // Delete
    }

}
