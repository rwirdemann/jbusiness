package org.jbusiness.samples.shop.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Payment {
    private String uid;
    private String  orderUid;

    @JsonCreator
    public Payment(@JsonProperty("uid") String uid, @JsonProperty("orderUid") String orderUid) {
        this.uid = uid;
        this.orderUid = orderUid;
    }

    public String getUid() {
        return uid;
    }

    public String getOrderUid() {
        return orderUid;
    }
}
