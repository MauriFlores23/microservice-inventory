package com.mauriflores.ms.inventoryservice.application.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mauriflores.ms.inventoryservice.domain.Product;
import com.mauriflores.ms.inventoryservice.domain.exception.ProductNotFoundException;
import com.mauriflores.ms.inventoryservice.domain.port.in.ProductUseCase;
import com.mauriflores.ms.inventoryservice.domain.port.out.ProductRepository;
import com.mauriflores.ms.inventoryservice.infrastructure.adapter.in.ProductRequest;
import com.mauriflores.ms.inventoryservice.infrastructure.adapter.in.ProductResponse;
import com.mauriflores.ms.inventoryservice.infrastructure.adapter.mapper.ProductMapper;

@Service
public class ProductService implements ProductUseCase{


    private final ProductRepository productRepository;

    

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponse create(ProductRequest request) {       
        if (request == null) {
            throw new RuntimeException("Error request vacio!!");
        } 
        System.out.println(request.toString());
        Product product = ProductMapper.mapperToDomain(request);
        product.setCreatedAt(LocalDateTime.now());
        return ProductMapper.mapperToResponse( productRepository.save(product));        
    }

    @Override
    public void delete(Long id) {
        if (productRepository.findProductById(id).isEmpty()) {
            throw new ProductNotFoundException(id);
        }
        productRepository.deleteById(id);
        
    }

    @Override
    public List<ProductResponse> findAll(String category) {
                return productRepository.findByCategory(category)
                    .stream()
                    .map(ProductMapper::mapperToResponse)
                    .collect(Collectors.toList());
    }

    @Override
    public ProductResponse findById(Long id) {
        Product product = productRepository.findProductById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        return ProductMapper.mapperToResponse(product);
    }

    @Override
    public ProductResponse updateStock(Long id, Integer stock) {
        
        if (stock < 0){
            throw new IllegalArgumentException("Stock cannot be negative");
        }
        Product product = productRepository.findProductById(id)
        .orElseThrow(() -> new ProductNotFoundException(id));

        product.setStock(stock);
        product.setUpdateAt(LocalDateTime.now());
        return ProductMapper.mapperToResponse(productRepository.save(product));
    }


    
}
