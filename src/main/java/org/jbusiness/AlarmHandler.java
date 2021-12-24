package org.jbusiness;

import java.math.BigDecimal;

public interface AlarmHandler {

    void raise(BigDecimal threshold, BigDecimal variation);
}
