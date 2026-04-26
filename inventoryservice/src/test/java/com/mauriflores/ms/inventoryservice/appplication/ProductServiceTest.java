package com.mauriflores.ms.inventoryservice.appplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.mauriflores.ms.inventoryservice.application.service.ProductService;
import com.mauriflores.ms.inventoryservice.domain.Product;
import com.mauriflores.ms.inventoryservice.domain.port.out.ProductRepository;
import com.mauriflores.ms.inventoryservice.infrastructure.adapter.in.ProductRequest;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    public void createProductTest() {

        Product product = new Product();
        product.setId(1L);
        product.setName("Monitor");
        product.setStock(5);
        when(productRepository.findProductById(1L)).thenReturn(Optional.of(product));
        when(productRepository.save(any())).thenReturn(product);
        ProductRequest productRequest = new ProductRequest("Monitor", "Monitor MSI 24", "PC", 100.00, 10);
        var response = productService.create(productRequest);
        assertNotNull(response);
        assertEquals("Monitor", response.name());

    }

      @Test
  void shouldFailWhenStockIsNegative() {
    assertThrows(IllegalArgumentException.class, () -> productService.updateStock(1L, -1));
  }

    @Test
    void shouldUpdateStock() {
        var response = productService.updateStock(1L, 10);
        assertEquals(10, response.stock());
    }

    @Test
    void shouldThrowWhenProductNotFound() {
        assertThrows(RuntimeException.class, () -> {
            productService.updateStock(1L, 5);
        });
    }

}
