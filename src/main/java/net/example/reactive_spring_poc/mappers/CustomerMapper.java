package net.example.reactive_spring_poc.mappers;

import net.example.reactive_spring_poc.repositories.Customer;
import net.example.reactive_spring_poc.api.CustomerDTO;

public class CustomerMapper {

    public static CustomerDTO toCustomerDTO(Customer customer) {
        return new CustomerDTO(customer.id(), customer.name());
    }
}
