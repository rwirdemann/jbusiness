package org.jbusiness.samples.shop.client;

import lombok.extern.slf4j.Slf4j;
import org.jbusiness.samples.shop.service.Order;
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
public class CustomerClient {
    public static void main(String[] args) {
        SpringApplication.run(CustomerClient.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) {
        return args -> {
            for (; ; ) {
                Order order = new Order();
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                Order created = restTemplate.postForObject("http://localhost:8080/orders", new HttpEntity<>(order, headers), Order.class);
                log.info("created {}", created);

                Payment payment = new Payment();
                payment.setOrderUid(created.getUid());
                HttpHeaders paymentHeaders = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                String url = restTemplate.postForObject("http://localhost:8080/payments", new HttpEntity<>(payment, paymentHeaders), String.class);
                log.info("payment {}", url);

                Thread.sleep(1000);
            }
        };
    }
}
