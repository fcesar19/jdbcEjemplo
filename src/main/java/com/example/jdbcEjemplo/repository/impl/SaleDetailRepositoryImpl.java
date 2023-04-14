package com.example.jdbcEjemplo.repository.impl;


import com.example.jdbcEjemplo.model.Product;
import com.example.jdbcEjemplo.model.SaleDetail;
import com.example.jdbcEjemplo.repository.SaleDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SaleDetailRepositoryImpl implements SaleDetailRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<SaleDetail> getSaleDetailsBySaleId(String saleId) {
        String sql = "SELECT * FROM SaleDetail WHERE idSale = ?";
        List<SaleDetail> listSaleDetails = jdbcTemplate.query(sql,
                (rs, rowNum) -> mapToSaleDetail(rs), saleId);
        return listSaleDetails;
    }

    private SaleDetail mapToSaleDetail(ResultSet rs) throws SQLException {
        SaleDetail saleDetail = new SaleDetail();
        saleDetail.setId(rs.getInt("id"));
        Product product = new Product();
        product.setId(rs.getInt("idProduct"));
        saleDetail.setQuantity(rs.getInt("quantity"));
        saleDetail.setSubtotal(rs.getDouble("subtotal"));
        saleDetail.setProduct(product);

        return saleDetail;
    }

    @Override
    public SaleDetail createSaleDetail(String saleId, SaleDetail saleDetail) {
        return null;
    }
}
