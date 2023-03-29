package net.example.reactive_spring_poc.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DemoApi {
     @GetMapping("/{id}")
     Mono<CustomerDTO> getCustomer(String id);

     @PostMapping
     Mono<CustomerDTO> createCustomer(CreateCustomerRequest request);

     @GetMapping
     Flux<CustomerDTO> getCustomersByName(@RequestParam String name);

     @DeleteMapping
     Mono<Void> deleteAllCustomers();
}
