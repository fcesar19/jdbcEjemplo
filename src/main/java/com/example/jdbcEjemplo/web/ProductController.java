package com.example.jdbcEjemplo.web;


import com.example.jdbcEjemplo.bussines.ProductService;
import com.example.jdbcEjemplo.dto.ProductDTO;
import com.example.jdbcEjemplo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public List<Product> getProduct() throws SQLException, ClassNotFoundException {
        return productService.getProduct();
    }
    @GetMapping("/{id}")
    public List<Product> getProductById(@PathVariable int id) throws SQLException, ClassNotFoundException {
        return productService.getProductById(id);
    }

    @PostMapping("")
    public Product createProduct(@RequestBody Product product) throws SQLException, ClassNotFoundException {
        return  productService.createProduct(product);
    }
}
