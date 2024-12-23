package com.prices.hex.infrastructure.adapter.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "PRICES")
public class PriceEntity {
    
    @Id
    @Column(name = "PRICE_LIST")
    private Integer priceList;
    @NotNull
    @Column(name = "BRAND_ID", nullable = false)
    private Long brandId;
    @NotNull
    @Column(name = "PRODUCT_ID", nullable = false)
    private Long productId;
    @NotNull
    @Column(name = "PRIORITY", nullable = false)
    private Integer priority;
    @NotNull
    @Column(name = "CURR", nullable = false)
    private String currency;
    @NotNull
    @Column(name = "PRICE", nullable = false)
    private BigDecimal price;
    @NotNull
    @Column(name = "START_DATE", nullable = false)
    private LocalDateTime startDate;
    @NotNull
    @Column(name = "END_DATE", nullable = false)
    private LocalDateTime endDate;    
    
    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Integer getPriceList() {
        return priceList;
    }

    public void setPriceList(Integer priceList) {
        this.priceList = priceList;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    
}
