package com.prices.hex.infrastructure.adapter.persistence.repository;

import com.prices.hex.infrastructure.adapter.persistence.entity.Price;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricesRepository extends JpaRepository<Price, Long>  {

    Optional<Price> findTopByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
        Long brandId, Long productId, LocalDateTime date1, LocalDateTime date2
    );   
    
}
