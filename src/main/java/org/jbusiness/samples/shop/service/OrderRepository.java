package org.jbusiness.samples.shop.service;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
    Order findByUid(String orderUid);
}
