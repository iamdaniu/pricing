package de.daniu.home.pricing;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface PricingService {
    void addTarif(Tarif tarif);
    List<? extends Tarif> getTarife();
    Optional<? extends Tarif> getTarif(String name);
}
