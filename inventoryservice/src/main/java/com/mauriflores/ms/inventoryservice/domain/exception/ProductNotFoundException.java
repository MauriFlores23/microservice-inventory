package com.mauriflores.ms.inventoryservice.domain.exception;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(Long id) {
        super("Product Not Found Exception! >>" + id);
    }

    

}
