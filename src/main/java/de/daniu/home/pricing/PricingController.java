package de.daniu.home.pricing;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@Controller
@RequestMapping(value = "/pricing")
class PricingController {

    @Autowired
    private PricingService service;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Tarif> addTarif(@RequestBody TarifTo tarif) {
        service.addTarif(tarif);

        return new ResponseEntity<>(tarif, OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<? extends Tarif>> getTarife() {
        return new ResponseEntity<>(service.getTarife(), OK);
    }

    @RequestMapping(value = "/{tarifName]", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<? extends Tarif> getTarif(@PathVariable("tarifName") String name) {
        return service.getTarif(name)
                .map(t -> new ResponseEntity<>(t, OK))
                .orElseGet(() -> new ResponseEntity<>(NOT_FOUND));
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    static class TarifTo implements Tarif {
        private String name;
        private BigDecimal pricePerUnit;
        private BigDecimal basePricePerDay;
    }
}
