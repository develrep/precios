package com.prices.hex.domain.exception;

public class PriceNotFoundException extends RuntimeException {
    
    public PriceNotFoundException(String msg){
        super(msg);
    }
}
