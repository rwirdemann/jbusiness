package org.jbusiness.samples.shop.service;

import lombok.Data;

@Data
public class Payment {
    private String uid;
    private long orderId;
}
