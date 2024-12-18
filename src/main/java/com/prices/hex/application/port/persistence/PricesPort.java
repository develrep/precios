package com.prices.hex.application.port.persistence;

import com.prices.hex.infrastructure.adapter.persistence.entity.Price;
import java.time.LocalDateTime;
import java.util.Optional;

public interface PricesPort {
    
    public Optional<Price> findPrice(Long brandId, Long productId, LocalDateTime date);
    
}
