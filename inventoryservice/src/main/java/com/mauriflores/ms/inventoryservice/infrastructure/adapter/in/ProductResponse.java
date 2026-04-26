package com.mauriflores.ms.inventoryservice.infrastructure.adapter.in;

public record ProductResponse(
    Long id,
    String name,
    String description,
    String category,
    Double price,
    Integer stock
) {

}
