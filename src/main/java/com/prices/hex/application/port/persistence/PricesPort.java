package com.prices.hex.application.port.persistence;

import com.prices.hex.domain.model.Price;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PricesPort {
    
    public List<Price> findAll();
    
    public Optional<Price> findPrice(Long brandId, Long productId, LocalDateTime date);
    
}
