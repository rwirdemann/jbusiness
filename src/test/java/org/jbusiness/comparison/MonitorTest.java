package org.jbusiness.comparison;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MonitorTest {

    @Mock
    private VariationListener listener;

    @Mock
    private ValueProvider valueProvider;

    @Test
    void shouldCallVariationListenerAfterBothWindowsFilled() {
        Monitor m = Monitor.builder()
                .windowSize(1)
                .pollingInterval(1000)
                .valueProvider(valueProvider)
                .variationListener(listener).build();
        m.addValue(new BigDecimal("2"));
        m.addValue(new BigDecimal("2"));
        verify(listener, Mockito.times(1)).handle(BigDecimal.ZERO);
    }

    @Test
    void shouldCalcVariationInPercent() {
        Monitor m = Monitor.builder()
                .windowSize(2)
                .pollingInterval(1000)
                .valueProvider(valueProvider)
                .variationListener(listener).build();
        m.addValue(new BigDecimal("3"));
        m.addValue(new BigDecimal("3"));
        m.addValue(new BigDecimal("1"));
        m.addValue(new BigDecimal("1"));
        verify(listener, Mockito.times(1)).handle(new BigDecimal("67.00"));

        m.addValue(new BigDecimal("1"));
        m.addValue(new BigDecimal("1"));
        verify(listener, Mockito.times(1)).handle(BigDecimal.ZERO);
    }
}