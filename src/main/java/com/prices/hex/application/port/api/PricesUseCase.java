package com.prices.hex.application.port.api;

import com.prices.hex.domain.model.Price;
import java.time.LocalDateTime;
import java.util.List;

public interface PricesUseCase {
    
    public List<Price> findAll();
    
    public Price findPrice(Long brandId, Long productId, LocalDateTime date);
    
}