package de.daniu.home.pricing;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface Tarif {
    String getName();
    BigDecimal getBasePricePerDay();
    BigDecimal getPricePerUnit();

    static BigDecimal basePriceFromMonthly(BigDecimal monthlyPrice) {
        return basePriceFromYearly(BigDecimal.valueOf(12L).multiply(monthlyPrice));
    }
    static BigDecimal basePriceFromYearly(BigDecimal yearlyPrice) {
        return yearlyPrice.divide(BigDecimal.valueOf(365L), RoundingMode.HALF_UP);
    }
}
