package com.mauriflores.ms.inventoryservice.infrastructure.adapter.mapper;

import java.time.LocalDateTime;

import com.mauriflores.ms.inventoryservice.domain.Product;
import com.mauriflores.ms.inventoryservice.infrastructure.adapter.in.ProductRequest;
import com.mauriflores.ms.inventoryservice.infrastructure.adapter.in.ProductResponse;

public class ProductMapper {

    public static Product mapperToDomain(ProductRequest request) {
        Product product = new Product();
        product.setName(request.name());
        product.setDescription(request.description());
        product.setCategory(request.category());
        product.setPrice(request.price());
        product.setStock(request.stock());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdateAt(LocalDateTime.now());
        return product;
    }

    public static ProductResponse mapperToResponse(Product product) {
        return new ProductResponse(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getCategory(),
            product.getPrice(),
            product.getStock()
        );
    }
}
