package com.prices.hex.infrastructure.adapter.persistence.mapper;

import com.prices.hex.domain.model.Price;
import com.prices.hex.infrastructure.adapter.persistence.entity.PriceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceEntityMapper {

    Price toPrice(PriceEntity priceEntity);

}