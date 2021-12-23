package org.jbusiness.comparison;

import java.math.BigDecimal;
import java.util.Random;

public record RandomValueProvider(int lowerBound, int upperBound) implements ValueProvider {

    @Override
    public BigDecimal get() {
        Random randomObj = new Random();
        int i = randomObj.ints(lowerBound, upperBound).findFirst().orElseGet(() -> 0);
        return new BigDecimal(i);
    }
}
