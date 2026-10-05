package org.example.ebankservice.feign;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.ebankservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")//Cette interface est un client HTTP qui permet de communiquer avec un autre service (!!!en indiquant son nom )

public interface CustomerRestClient {

    @GetMapping("/customers/{id}")
   @CircuitBreaker(name = "customer", fallbackMethod = "getDefaultCustomer")
    Customer getCustomerById(@PathVariable Long id );
    default Customer getDefaultCustomer( Long id,Exception e ){
        return new Customer(id, "NoName","NoEmail");
    }
}
