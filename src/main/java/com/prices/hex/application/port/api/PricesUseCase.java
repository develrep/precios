package com.prices.hex.application.port.api;

import com.prices.hex.infrastructure.adapter.persistence.entity.Price;
import java.time.LocalDateTime;

public interface PricesUseCase {
    
    public Price findPrice(Long brandId, Long productId, LocalDateTime date);
    
}