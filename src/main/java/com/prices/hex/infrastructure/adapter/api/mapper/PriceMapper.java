package com.prices.hex.infrastructure.adapter.api.mapper;

import com.prices.hex.domain.model.Price;
import com.prices.hex.infrastructure.adapter.api.dto.PriceResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapper {
    
    PriceResponseDto toPriceResponseDto(Price price);
    
}