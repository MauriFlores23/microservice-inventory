package com.mauriflores.ms.inventoryservice.infrastructure.adapter.out;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mauriflores.ms.inventoryservice.domain.Product;

public interface ProductJpaRepository extends JpaRepository<Product, Long>{

  List<Product> findByCategoryIgnoreCase(String category);
  
  List<Product> findByStockGreaterThan(Integer stock);

}
