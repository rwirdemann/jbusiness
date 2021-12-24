package org.jbusiness.example;

import org.jbusiness.DataProvider;

import java.math.BigDecimal;
import java.util.Random;

public record RandomDataProvider(int lowerBound, int upperBound) implements DataProvider {

    @Override
    public BigDecimal get() {
        Random randomObj = new Random();
        int i = randomObj.ints(lowerBound, upperBound).findFirst().orElseGet(() -> 0);
        return new BigDecimal(i);
    }
}
