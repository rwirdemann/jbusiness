package org.bhealth.comparison;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Monitor {
    private final int windowSize;
    private List<BigDecimal> currentValues;
    private int currentIndex;
    private List<BigDecimal> nextValues;
    private int nextIndex;
    private VariationListener variationListener;

    public Monitor(int windowSize, VariationListener variationListener) {
        this.windowSize = windowSize;
        this.variationListener = variationListener;
        currentValues = new ArrayList<>();
        currentIndex = 0;
        nextValues = new ArrayList<>();
        nextIndex = 0;
    }

    public void addValue(BigDecimal value) {
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
    }

    private void compare() {
        BigDecimal variation = nextMean().divide(currentMean(), RoundingMode.UP);
        variationListener.handle(variation);
    }

    public BigDecimal currentMean() {
        return currentValues.stream().reduce(BigDecimal.ZERO, BigDecimal::add).divide(new BigDecimal(currentValues.size()), RoundingMode.UP);
    }

    public BigDecimal nextMean() {
        return nextValues.stream().reduce(BigDecimal.ZERO, BigDecimal::add).divide(new BigDecimal(nextValues.size()), RoundingMode.UP);
    }
}
