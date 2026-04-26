package com.mauriflores.ms.inventoryservice.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Product {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     @Column
    private String name;
     @Column
    private String description;
     @Column
    private String category;
     @Column
    private Double price;
     @Column
    private Integer stock;
     @Column
    private LocalDateTime createdAt;
     @Column
    private LocalDateTime updatedAt;

public Product(){}
    
     public Product(String name, String description, String category, Double price, int stock,
            LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
     public Long getId() {
         return id;
     }
     public void setId(Long id) {
         this.id = id;
     }
     public String getName() {
         return name;
     }
     public void setName(String name) {
         this.name = name;
     }
     public String getDescription() {
         return description;
     }
     public void setDescription(String description) {
         this.description = description;
     }
     public String getCategory() {
         return category;
     }
     public void setCategory(String category) {
         this.category = category;
     }
     public Double getPrice() {
         return price;
     }
     public void setPrice(Double price) {
         this.price = price;
     }
     public int getStock() {
         return stock;
     }
     public void setStock(int stock) {
         this.stock = stock;
     }
     public LocalDateTime getCreatedAt() {
         return createdAt;
     }
     public void setCreatedAt(LocalDateTime createdAt) {
         this.createdAt = createdAt;
     }
     public LocalDateTime getUpdateAt() {
         return updatedAt;
     }
     public void setUpdateAt(LocalDateTime updatedAt) {
         this.updatedAt = updatedAt;
     }

    
}
