package com.prices.hex.infrastructure.adapter.persistence.repository;

import com.prices.hex.infrastructure.adapter.persistence.entity.PriceEntity;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricesRepository extends JpaRepository<PriceEntity, Long>  {

    Optional<PriceEntity> findTopByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
        Long brandId, Long productId, LocalDateTime date1, LocalDateTime date2
    );   
    
}
