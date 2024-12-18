package com.prices.hex.domain;

import com.prices.hex.application.port.api.PricesUseCase;
import com.prices.hex.infrastructure.adapter.persistence.PricesPersistenceAdapter;
import com.prices.hex.infrastructure.adapter.persistence.entity.Price;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceService implements PricesUseCase {
    
    @Autowired
    private PricesPersistenceAdapter pricesPort;
    
    @Override
    public Price findPrice(Long brandId, Long productId, LocalDateTime date) {
        return pricesPort.findPrice(brandId, productId, date)
                         .orElseThrow(() -> new PriceNotFoundException("No se encontro la tarifa"));
    }    
    
}
