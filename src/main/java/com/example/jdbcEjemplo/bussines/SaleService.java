package com.example.jdbcEjemplo.bussines;

import com.example.jdbcEjemplo.dto.SaleDTO;
import com.example.jdbcEjemplo.model.Sale;

import java.util.List;

public interface SaleService {
    public List<Sale> getSales();
    public Sale createSale(SaleDTO saleDTO);
}
