package de.daniu.home.pricing.service;

import de.daniu.home.pricing.Tarif;
import de.daniu.home.pricing.database.TarifEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarifEntityMapper {
    TarifEntity from(Tarif tarif);
}
