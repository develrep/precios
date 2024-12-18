package com.prices.hex.domain;

public class PriceNotFoundException extends RuntimeException {
    
    public PriceNotFoundException(String msg){
        super(msg);
    }
}
