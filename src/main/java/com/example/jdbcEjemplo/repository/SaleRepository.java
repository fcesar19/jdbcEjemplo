package com.example.jdbcEjemplo.repository;

import com.example.jdbcEjemplo.model.Sale;

import java.util.List;

public interface SaleRepository {

    public List<Sale> getSales();
    public Sale createSale(Sale sale);
}
