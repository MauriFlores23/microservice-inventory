package com.mauriflores.ms.inventoryservice.infrastructure.adapter.out;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.mauriflores.ms.inventoryservice.domain.Product;
import com.mauriflores.ms.inventoryservice.domain.port.out.ProductRepository;

@Component
public class ProductJpaRepositoryAdapter  implements ProductRepository{

    private final ProductJpaRepository productJpaRepository;

    
    public ProductJpaRepositoryAdapter(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    @Override
    public List<Product> findAllProducts() {
        // TODO Auto-generated method stub
        return productJpaRepository.findAll();
    }

    @Override
    public List<Product> findByCategory(String category) {
        // TODO Auto-generated method stub
        return productJpaRepository.findByCategoryIgnoreCase(category);
    }

    @Override
    public List<Product> findByStock(Integer stock) {
        // TODO Auto-generated method stub
        return productJpaRepository.findByStockGreaterThan(stock);
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        // TODO Auto-generated method stub
        return productJpaRepository.findById(id);
    }

    @Override
    public Product save(Product product) {        
        return productJpaRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {        
        productJpaRepository.deleteById(id);
    }

    

    
}
