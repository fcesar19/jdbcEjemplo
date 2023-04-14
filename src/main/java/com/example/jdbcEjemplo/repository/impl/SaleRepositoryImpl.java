package com.example.jdbcEjemplo.repository.impl;

import com.example.jdbcEjemplo.model.Client;
import com.example.jdbcEjemplo.model.Sale;
import com.example.jdbcEjemplo.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SaleRepositoryImpl implements SaleRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    //Se crea un repositorio con la inyeccion jdbcTemplate

    @Override
    public List<Sale> getSales() {
        String sql = "SELECT * FROM sale";
        List<Sale> sales=jdbcTemplate.query(sql,(rs,rowNum)->mapToSale(rs));
        return sales;
    }

    @Override
    public Sale createSale(Sale sale) {
        return null;
    }

    //metodo para mandar el resulset
    private Sale mapToSale(ResultSet rs) throws SQLException {
        Sale sale = new Sale();
        sale.setId(rs.getInt("id"));
        sale.setTotal(rs.getDouble("total"));
        Client client = new Client();
        client.setId(rs.getInt("idClient"));
        sale.setIdClient(client);

        return sale;
    }
}
