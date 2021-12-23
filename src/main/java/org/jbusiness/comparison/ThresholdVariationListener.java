package org.jbusiness.comparison;

import java.math.BigDecimal;

public class ThresholdVariationListener implements VariationListener {

    private final BigDecimal threshold;

    public ThresholdVariationListener(BigDecimal threshold) {
        this.threshold = threshold;
    }

    @Override
    public void handle(BigDecimal variation) {
        System.out.println("ThresholdVariationListener.handle: " + variation);
    }
}
