package org.jbusiness.comparison;

import java.math.BigDecimal;

public interface VariationListener {

    void handle(BigDecimal variation);
}
