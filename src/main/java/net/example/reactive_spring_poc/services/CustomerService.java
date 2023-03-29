package net.example.reactive_spring_poc.services;

import lombok.RequiredArgsConstructor;
import net.example.reactive_spring_poc.api.CreateCustomerRequest;
import net.example.reactive_spring_poc.mappers.CustomerMapper;
import net.example.reactive_spring_poc.repositories.Customer;
import net.example.reactive_spring_poc.repositories.CustomerRepository;
import net.example.reactive_spring_poc.api.CustomerDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repo;
    
    public Mono<CustomerDTO> getCustomer(String id) {
//        return Mono.just(new CustomerDTO(id, "Test"));
        return repo.findById(id).map(CustomerMapper::toCustomerDTO);
    }

    public Mono<CustomerDTO> createCustomer(CreateCustomerRequest request) {
//        return Mono.just(new CustomerDTO(UUID.randomUUID().toString(), request.name()));
        return repo.save(new Customer(UUID.randomUUID().toString(), request.name()))
                .map(CustomerMapper::toCustomerDTO);
    }

    public Flux<CustomerDTO> findCustomerByName(String name) {
//        return Flux.just(
//                new CustomerDTO(UUID.randomUUID().toString(), name),
//                new CustomerDTO(UUID.randomUUID().toString(), name)
//        );
        return repo.findCustomerByNameContainingIgnoreCase(name).map(CustomerMapper::toCustomerDTO);
    }

    public Mono<Void> deleteAll() {
        return repo.deleteAll();
    }
}
