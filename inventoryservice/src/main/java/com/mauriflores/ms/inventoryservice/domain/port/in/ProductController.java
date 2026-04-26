package com.mauriflores.ms.inventoryservice.domain.port.in;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mauriflores.ms.inventoryservice.infrastructure.adapter.in.ProductRequest;
import com.mauriflores.ms.inventoryservice.infrastructure.adapter.in.ProductResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductUseCase productUseCase;

    public ProductController(ProductUseCase productUseCase) {
        this.productUseCase = productUseCase;
    }

    @Operation(
    summary = "Crear producto",
    description = "Registra un nuevo producto en el inventario"
)
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Producto creado"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    public ResponseEntity<ProductResponse> create(@Valid @org.springframework.web.bind.annotation.RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(productUseCase.create(productRequest));
    }

    @Operation(
        summary = "Listar productos",
        description = "Obtiene todos los productos por categoría"
    )
    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll(@RequestParam(name = "category") String category){
        return ResponseEntity.ok(productUseCase.findAll(category));
    }

    @Operation(summary = "Obtener producto por Id")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Producto encontrado"),
        @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(productUseCase.findById(id));
    }
    @Operation(summary = "Actualizar stock de producto")    
    @PutMapping("/{id}/stock")
    public ResponseEntity<ProductResponse> findById(@PathVariable("id") Long id,
                                                                                        @RequestParam("stock") Integer stock) {
        return ResponseEntity.ok(productUseCase.updateStock(id, stock));
    }

    @Operation(summary = "Eliminar de producto")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        productUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }
}
