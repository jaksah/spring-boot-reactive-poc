package net.example.reactive_spring_poc.clients;

import net.example.reactive_spring_poc.api.DemoApi;
import reactivefeign.spring.config.ReactiveFeignClient;

@ReactiveFeignClient(value = "application-client", url = "localhost:8080")
public interface DemoApiClient extends DemoApi {

}