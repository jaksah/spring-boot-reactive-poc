package net.example.reactive_spring_poc.controllers;

import lombok.RequiredArgsConstructor;
import net.example.reactive_spring_poc.api.CreateCustomerRequest;
import net.example.reactive_spring_poc.api.CustomerDTO;
import net.example.reactive_spring_poc.api.DemoApi;
import net.example.reactive_spring_poc.services.CustomerService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class DemoApiController implements DemoApi {

    private final CustomerService service;

    @Override
    public Mono<CustomerDTO> getCustomer(String id) {
        return service.getCustomer(id);
    }

    @Override
    public Mono<CustomerDTO> createCustomer(@RequestBody CreateCustomerRequest request) {
        return service.createCustomer(request);
    }

    @Override
    public Flux<CustomerDTO> getCustomersByName(String name) {
        return service.findCustomerByName(name);
    }

    @Override
    public Mono<Void> deleteAllCustomers() {
        return service.deleteAll();
    }

}
