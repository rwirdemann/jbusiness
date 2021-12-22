package org.bhealth.comparison;

import java.math.BigDecimal;

public interface VariationListener {

    void handle(BigDecimal variation);
}
