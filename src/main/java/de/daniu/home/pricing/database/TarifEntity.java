package de.daniu.home.pricing.database;

import de.daniu.home.pricing.Tarif;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Entity
@Table(name="tarife")
public class TarifEntity implements Tarif {
    @Id
    @NotNull
    private String name;

    @NotNull
    private BigDecimal basePricePerDay;
    @NotNull
    private BigDecimal pricePerUnit;
}
