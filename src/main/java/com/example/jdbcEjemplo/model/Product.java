package com.example.jdbcEjemplo.model;

import com.example.jdbcEjemplo.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private int id;
    private String description;
    private double cost;

    public Product(ProductDTO productDTO){
        this.description=productDTO.getDescription();
        this.cost=productDTO.getCost();
    }
}
