package org.jbusiness.samples.shop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class CheckoutController {

    @PostMapping("/payments")
    public String createPayment(Payment payment) {
        log.info("createPayment: {}", payment);
        String uid = UUID.randomUUID().toString();
        return "http://localhost:8080/" + uid;
    }
}
