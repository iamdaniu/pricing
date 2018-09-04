package de.daniu.home.pricing.service;

import de.daniu.home.pricing.PricingService;
import de.daniu.home.pricing.Tarif;
import de.daniu.home.pricing.database.TarifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RepositoryPricingService implements PricingService {
    @Autowired
    private TarifEntityMapper mapper;

    @Autowired
    private TarifRepository repository;

    @Override
    public void addTarif(Tarif tarif) {
        repository.save(mapper.from(tarif));
    }

    @Override
    public List<Tarif> getTarife() {
        return new ArrayList<>(repository.findAll());
    }
}
