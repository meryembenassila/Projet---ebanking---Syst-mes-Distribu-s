package org.example.customer_service.service;


import lombok.AllArgsConstructor;
import org.example.customer_service.entities.Customer;
import org.example.customer_service.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll() ;   }


public Customer getAllCustomerByID(Long id ){
    return customerRepository.findById(id).orElseThrow(()->new RuntimeException("Customer Not Found"));

}

public Customer save(Customer customer){
        return customerRepository.save(customer);

    }
}
