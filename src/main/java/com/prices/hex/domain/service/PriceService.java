package com.prices.hex.domain.service;

import com.prices.hex.domain.exception.PriceNotFoundException;
import com.prices.hex.application.port.api.PricesUseCase;
import com.prices.hex.domain.model.Price;
import com.prices.hex.infrastructure.adapter.persistence.PricesPersistenceAdapter;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PriceService implements PricesUseCase {
    
    private final PricesPersistenceAdapter pricesPort;
    
    public PriceService(PricesPersistenceAdapter pricesPort) {
        this.pricesPort = pricesPort;
    }
    
    public List<Price> findAll() {
        return pricesPort.findAll();
    }
    
    @Override
    public Price findPrice(Long brandId, Long productId, LocalDateTime date) {
        return pricesPort.findPrice(brandId, productId, date)
                         .orElseThrow(() -> new PriceNotFoundException("No se encontro la tarifa"));
    }    
    
}
