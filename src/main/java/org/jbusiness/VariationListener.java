package org.jbusiness;

import java.math.BigDecimal;

public interface VariationListener {

    void handle(BigDecimal variation);
}
