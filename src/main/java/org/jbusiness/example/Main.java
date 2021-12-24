package org.jbusiness.example;

import org.jbusiness.*;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        RandomDataProvider dataProvider = new RandomDataProvider(4, 10);
        AlarmHandler alarmHandler = new LogAlarmHandler();
        ThresholdVariationListener thresholdListener = new ThresholdVariationListener(new BigDecimal("15"), alarmHandler);

        Monitor m = Monitor.builder()
                .windowSize(5)
                .pollingInterval(1000)
                .dataProvider(dataProvider)
                .variationListener(thresholdListener).build();
        m.run();
    }
}
