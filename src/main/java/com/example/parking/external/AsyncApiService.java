package com.example.parking.external;


import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncApiService {

    private final WebClient webClient;

    public AsyncApiService(WebClient webClient) {
        this.webClient = webClient;
    }

    @Async("customExecutor")
    public CompletableFuture<String> fetchDataFromOtherService(String url) {
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .toFuture(); // Converts Mono to CompletableFuture
    }
}
