package de.daniu.home.pricing;

import java.util.Collection;
import java.util.List;

public interface PricingService {
    void addTarif(Tarif tarif);
    List<Tarif> getTarife();
}
