package org.jbusiness.samples.shop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CheckoutController {

    private final CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/orders")
    public @ResponseBody
    Order createPayment(@RequestBody Order order) {
        return checkoutService.createOrder(order);
    }

    @PostMapping("/payments")
    public String createPayment(@RequestBody Payment payment) {
        String paymentUUID = checkoutService.createPayment(payment);
        return "http://localhost:8080/payments/" + paymentUUID;
    }
}
