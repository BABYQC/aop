package com.example.aop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @Author: chang qi
 * @Date: 2024/12/10
 */
@Service
public class WebClientService {

    private final WebClient.Builder webClientBuilder;

    public WebClientService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public Mono<String> getExample() {
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:8080/cloudFile/10301782671063067529216")
                .retrieve()
                .bodyToMono(String.class);
    }
}
