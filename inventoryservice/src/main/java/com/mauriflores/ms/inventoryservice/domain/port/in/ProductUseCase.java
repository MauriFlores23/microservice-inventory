package com.mauriflores.ms.inventoryservice.domain.port.in;

import java.util.List;

import com.mauriflores.ms.inventoryservice.infrastructure.adapter.in.ProductRequest;
import com.mauriflores.ms.inventoryservice.infrastructure.adapter.in.ProductResponse;

public interface ProductUseCase {

    ProductResponse create(ProductRequest request);

    ProductResponse updateStock(Long id, Integer stock);

    List<ProductResponse> findAll(String category);

    ProductResponse findById(Long id);

    void delete(Long id);
}
