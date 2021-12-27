package org.jbusiness.samples.shop.client;

import lombok.extern.slf4j.Slf4j;
import org.jbusiness.samples.shop.service.Payment;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Slf4j
public class Buyer {
    public static void main(String[] args) {
        SpringApplication.run(Buyer.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) {
        return args -> {
            Payment payment = new Payment();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Payment> request = new HttpEntity<>(payment, headers);
            String url = restTemplate.postForObject("http://localhost:8080/payments", request, String.class);
            log.info("payment {}", url);
        };
    }
}
