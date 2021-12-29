package org.jbusiness.samples.shop.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonProperty
    private String uid;

    @JsonProperty
    private String  orderUid;

    public String getUid() {
        return uid;
    }

    public String getOrderUid() {
        return orderUid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setOrderUid(String orderUid) {
        this.orderUid = orderUid;
    }
}
