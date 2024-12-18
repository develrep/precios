package com.prices.hex.infrastructure.adapter.persistence;

import com.prices.hex.application.port.persistence.PricesPort;
import com.prices.hex.infrastructure.adapter.persistence.repository.PricesRepository;
import com.prices.hex.infrastructure.adapter.persistence.entity.Price;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PricesPersistenceAdapter implements PricesPort {
    
    @Autowired
    private PricesRepository pricesRepository;
    
    @Override
    public Optional<Price> findPrice(Long brandId, Long productId, LocalDateTime date) {
        return pricesRepository.findTopByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(brandId, productId, date, date);
    }    
    
}
