package net.example.reactive_spring_poc.repositories;

import java.util.UUID;

public record Customer(
        String id,
        String name
) {
}
