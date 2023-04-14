package com.example.jdbcEjemplo.DAO;

import com.example.jdbcEjemplo.dto.ProductDTO;
import com.example.jdbcEjemplo.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {

    List<Product> getProduct() throws SQLException, ClassNotFoundException;
    Product createProduct(Product product) throws SQLException, ClassNotFoundException;
    List<Product> getProductById(Integer id) throws SQLException, ClassNotFoundException;
}
