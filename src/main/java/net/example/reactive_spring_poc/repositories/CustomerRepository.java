package net.example.reactive_spring_poc.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, String> {

    Flux<Customer> findCustomerByNameContainingIgnoreCase(String name);
}


