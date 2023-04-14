package com.example.jdbcEjemplo.model;

import com.example.jdbcEjemplo.dto.SaleDetailDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleDetail {
    private int id;
    private Product product;
    private int quantity;
    private double subtotal;

    public SaleDetail(SaleDetailDTO saleDetailDTO,Product product){
        this.product=product;
        this.quantity=saleDetailDTO.getQuantity();
        this.subtotal=saleDetailDTO.getQuantity()*product.getCost();
    }
}
