package com.example.aop.controller;

import com.example.aop.service.WebClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @Author: chang qi
 * @Date: 2024/12/10
 */
@RestController
public class WebClientController {

    private final WebClientService webClientService;

    public WebClientController(WebClientService webClientService) {
        this.webClientService = webClientService;
    }

    @GetMapping("/get-webclient")
    public Mono<String> getExample() {
        return webClientService.getExample();
    }
}

