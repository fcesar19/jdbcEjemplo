package com.example.jdbcEjemplo.bussines;

import com.example.jdbcEjemplo.DAO.ProductDAO;
import com.example.jdbcEjemplo.connection.BdConnect;
import com.example.jdbcEjemplo.dto.ProductDTO;
import com.example.jdbcEjemplo.model.Product;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements ProductDAO {
    @Override
    public List<Product> getProduct() throws SQLException, ClassNotFoundException {
        BdConnect.conectar();
        String sqlGetProduct="Select * from product";
        Statement st=BdConnect.conectar().createStatement();
        ResultSet rs=st.executeQuery(sqlGetProduct);
        List<Product> products=new ArrayList<Product>();
        while(rs.next()){
            Product product=new Product();
            product.setDescription(rs.getString("description"));
            product.setCost(rs.getDouble("cost"));
            products.add(product);
        }
        return products;
    }

    @Override
    public Product createProduct(Product product) throws SQLException, ClassNotFoundException {
        BdConnect.conectar();
        String sqlInsertarProducto="Insert into product(description,cost) values(?,?)";
        PreparedStatement ps=BdConnect.conectar().prepareStatement(sqlInsertarProducto);
        ps.setString(1,product.getDescription());
        ps.setDouble(2,product.getCost());
        ps.executeUpdate();
        return product;
    }

    @Override
    public List<Product> getProductById(Integer id) throws SQLException, ClassNotFoundException {
        BdConnect.conectar();
        String sqlGetProductId="{CALL getProductoID(?)}";
        CallableStatement cs=BdConnect.conectar().prepareCall(sqlGetProductId);
        cs.setInt("p_id",id);
        ResultSet rs=BdConnect.ejecutarprocalmacenado(cs);
        List<Product> products=new ArrayList<Product>();
        while(rs.next()){
            Product product=new Product();
            product.setId(rs.getInt("id"));
            product.setDescription(rs.getString("description"));
            product.setCost(rs.getDouble("cost"));
            products.add(product);
        }

        return products;
    }
}
