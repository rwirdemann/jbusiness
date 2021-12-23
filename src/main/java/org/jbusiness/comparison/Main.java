package org.jbusiness.comparison;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        RandomValueProvider valueProvider = new RandomValueProvider(4, 10);
        ThresholdVariationListener variationListener = new ThresholdVariationListener(new BigDecimal("15"));

        Monitor m = Monitor.builder()
                .windowSize(5)
                .pollingInterval(1000)
                .valueProvider(valueProvider)
                .variationListener(variationListener).build();
        m.run();
    }
}
