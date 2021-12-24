package org.jbusiness;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

@Builder
@Slf4j
public class Monitor {
    private final int windowSize;
    private final long pollingInterval;
    private final DataProvider dataProvider;
    private final VariationListener variationListener;

    private List<BigDecimal> currentValues;
    private int currentIndex;
    private List<BigDecimal> nextValues;
    private int nextIndex;

    public void addValue(BigDecimal value) {
        if (currentValues == null) {
            currentIndex = 0;
            currentValues = new ArrayList<>();
        }
        if (nextValues == null) {
            nextIndex = 0;
            nextValues = new ArrayList<>();
        }

        if (currentIndex < windowSize) {
            currentValues.add(currentIndex++, value);
            return;
        }
        if (nextIndex < windowSize) {
            nextValues.add(nextIndex++, value);
        }
        if (currentIndex == windowSize && nextIndex == windowSize) {
            compare();
            reset();
        }
    }

    private void reset() {
        nextIndex = 0;
        currentValues = new ArrayList<>(nextValues);
        nextValues = new ArrayList<>();
    }

    private void compare() {
        BigDecimal divide = nextSum().divide(currentSum(), new MathContext(2));
        BigDecimal variation = (BigDecimal.ONE.subtract(divide)).multiply(new BigDecimal("100"));
        log.info("current {} : {} next {} : {}", currentValues, currentSum(), nextValues, nextSum());
        variationListener.handle(variation);
    }

    private BigDecimal currentSum() {
        return currentValues.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal nextSum() {
        return nextValues.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void run() throws InterruptedException {
        while (true) {
            addValue(dataProvider.get());
            Thread.sleep(pollingInterval);
        }
    }
}
