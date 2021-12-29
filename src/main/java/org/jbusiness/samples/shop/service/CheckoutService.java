package org.jbusiness.samples.shop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CheckoutService {
    public String createPayment(Payment payment) {
        log.info("createPayment: {}", payment);
        return UUID.randomUUID().toString();
    }
}
