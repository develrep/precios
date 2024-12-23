package com.prices.hex.infrastructure.adapter.persistence;

import com.prices.hex.application.port.persistence.PricesPort;
import com.prices.hex.domain.model.Price;
import com.prices.hex.infrastructure.adapter.persistence.repository.PricesRepository;
import com.prices.hex.infrastructure.adapter.persistence.mapper.PriceEntityMapper;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class PricesPersistenceAdapter implements PricesPort {

    private final PricesRepository pricesRepository;
    
    private final PriceEntityMapper priceEntityMapper;
    
    public PricesPersistenceAdapter(PricesRepository pricesRepository, PriceEntityMapper priceEntityMapper) {
        this.pricesRepository = pricesRepository;
        this.priceEntityMapper = priceEntityMapper;
    }
    
    @Override
    public List<Price> findAll() {
        return pricesRepository.findAll().stream()
                .map(priceEntityMapper::toPrice)
                .collect(Collectors.toList());        
    }
    
    @Override
    public Optional<Price> findPrice(Long brandId, Long productId, LocalDateTime date) {
        return pricesRepository.findTopByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(brandId, productId, date, date)
                .map(priceEntityMapper::toPrice);
    }    
    
}
