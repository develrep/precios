package com.prices.hex.infrastructure.mapper;

import com.prices.hex.infrastructure.dto.PriceDto;
import com.prices.hex.infrastructure.adapter.persistence.entity.Price;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface PriceMapper {
    PriceDto toResponse(Price price);
}