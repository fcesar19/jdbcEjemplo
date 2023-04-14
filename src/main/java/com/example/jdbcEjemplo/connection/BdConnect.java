package com.example.jdbcEjemplo.connection;

import java.sql.*;

public class BdConnect {

    private static Connection conexion;

    public static Connection conectar() throws ClassNotFoundException, SQLException {

        String url="jdbc:mysql://localhost:3306/bd_jdbcejemplo";
        String username="root";
        String password="";

        conexion= DriverManager.getConnection(url,username,password);
        return conexion;
    }
    public static ResultSet ejecutarprocalmacenado(CallableStatement cs) throws SQLException {
        return cs.executeQuery();
    }
    public static Connection getConexion(){
        return conexion;
    }
}
