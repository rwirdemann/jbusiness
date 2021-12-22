package org.bhealth.comparison;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MonitorTest {

    @Mock
    private VariationListener listener;

    @Test
    void mean() {
        Monitor m = new Monitor(5, listener);
        m.addValue(new BigDecimal("2"));
        m.addValue(new BigDecimal("8"));
        m.addValue(new BigDecimal("7"));
        m.addValue(new BigDecimal("8"));
        m.addValue(new BigDecimal("10"));
        assertEquals(new BigDecimal("7"), m.currentMean());
    }

    @Test
    void shouldCallVariationListenerAfterBothWindowsFilled() {
        Monitor m = new Monitor(1, listener);
        m.addValue(new BigDecimal("2"));
        m.addValue(new BigDecimal("2"));
        verify(listener, Mockito.times(1)).handle(new BigDecimal("1"));
    }
}