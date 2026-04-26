package com.mauriflores.ms.inventoryservice.infrastructure.adapter.in;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record ProductRequest(
    @NotBlank String name,
    String description,
    @NotBlank String category,
    @NotNull @Positive Double price,
    @NotNull @PositiveOrZero Integer stock
) {
}
