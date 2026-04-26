package com.mauriflores.ms.inventoryservice.domain.port.out;

import java.util.List;
import java.util.Optional;

import com.mauriflores.ms.inventoryservice.domain.Product;

public interface ProductRepository {

    List<Product> findByCategory(String category);
    List<Product> findByStock(Integer stock);
    List<Product> findAllProducts();
    Optional<Product> findProductById(Long id);
    Product save(Product product);
    void deleteById(Long id);



    
} 