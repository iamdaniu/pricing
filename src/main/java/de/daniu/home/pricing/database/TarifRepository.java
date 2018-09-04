package de.daniu.home.pricing.database;

import de.daniu.home.pricing.Tarif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifRepository extends JpaRepository<TarifEntity,String> {
}
