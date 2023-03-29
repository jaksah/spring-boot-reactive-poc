package net.example.reactive_spring_poc;

import net.example.reactive_spring_poc.api.CreateCustomerRequest;
import net.example.reactive_spring_poc.clients.DemoApiClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class DemoApplicationTest {

    @Autowired
    private DemoApiClient client;


    @Test
    void Should_ReachApplication_When_UsingClient() {
        StepVerifier
                .create(Flux.concat(
                        client.createCustomer(new CreateCustomerRequest("Jan")),
                        client.createCustomer(new CreateCustomerRequest("Jansson")),
                        client.createCustomer(new CreateCustomerRequest("Olsson"))
                        ))
                .expectNextCount(3)
                .verifyComplete();
        StepVerifier
                .create(client.getCustomersByName("Jan"))
                .expectNextCount(2)
                .verifyComplete();

        StepVerifier
                .create(client.deleteAllCustomers())
                .verifyComplete();
    }

}
