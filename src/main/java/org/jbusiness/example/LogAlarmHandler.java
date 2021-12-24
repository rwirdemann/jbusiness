package org.jbusiness.example;

import lombok.extern.slf4j.Slf4j;
import org.jbusiness.AlarmHandler;

import java.math.BigDecimal;

@Slf4j
public class LogAlarmHandler implements AlarmHandler {
    @Override
    public void raise(BigDecimal threshold, BigDecimal variation) {
        log.error("Variation {} exceeds the defined threshold {}", variation, threshold);
    }
}
