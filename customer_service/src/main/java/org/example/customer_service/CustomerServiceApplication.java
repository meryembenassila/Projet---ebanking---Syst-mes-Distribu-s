package org.example.customer_service;

import org.example.customer_service.entities.Customer;
import org.example.customer_service.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);

    }


    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            List<String> names = List.of("Ahmed", "Ilhame", "Ali");
            names.forEach(name -> {
                Customer customer1 = new Customer();
                customer1.setName(name);
                customer1.setEmail(name + "@gamil.com");
                customerRepository.save(customer1);
            });


        };
        }



}
