package org.jbusiness.samples.shop;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckoutController {

    @PutMapping("/orders/{id}")
    public Order commit(@PathVariable("id") long orderId) {
        return new Order(orderId);
    }
}
