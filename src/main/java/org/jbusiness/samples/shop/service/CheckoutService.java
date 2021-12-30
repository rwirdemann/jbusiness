package org.jbusiness.samples.shop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CheckoutService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public CheckoutService(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    public String createPayment(Payment payment) {
        createOrderIfNotExists(payment);
        payment.setUid(UUID.randomUUID().toString());
        paymentRepository.save(payment);
        log.info("payment created: {}", payment);
        return payment.getUid();
    }

    private void createOrderIfNotExists(Payment payment) {
        if (orderRepository.findByUid(payment.getOrderUid()) != null) {
            return;
        }

        Order o = new Order();
        o.setUid(payment.getOrderUid());
        Order newOrder = orderRepository.save(o);
        log.info("order created: {}", newOrder);
    }

    public Order createOrder(Order order) {
        order.setUid(UUID.randomUUID().toString());
        Order created = orderRepository.save(order);
        log.info("order created: {}", created);
        return created;
    }
}
