package org.jbusiness.samples.helloworld;

import lombok.extern.slf4j.Slf4j;
import org.jbusiness.AlarmHandler;
import org.jbusiness.VariationListener;

import java.math.BigDecimal;

@Slf4j
public record ThresholdVariationListener(BigDecimal threshold, AlarmHandler alarmHandler) implements VariationListener {

    @Override
    public void handle(BigDecimal variation) {
        log.info("handle {}", variation);
        if (variation.compareTo(threshold) >= 0) {
            alarmHandler.raise(threshold, variation);
        }
    }
}
