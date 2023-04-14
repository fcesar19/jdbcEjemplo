package com.example.jdbcEjemplo.repository;

import com.example.jdbcEjemplo.model.SaleDetail;

import java.util.List;

public interface SaleDetailRepository {

    public List<SaleDetail> getSaleDetailsBySaleId(String saleId);
    public SaleDetail createSaleDetail(String saleId, SaleDetail saleDetail);
}
