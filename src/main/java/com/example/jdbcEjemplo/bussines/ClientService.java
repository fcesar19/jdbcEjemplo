package com.example.jdbcEjemplo.bussines;

import com.example.jdbcEjemplo.DAO.ClientDAO;
import com.example.jdbcEjemplo.connection.BdConnect;
import com.example.jdbcEjemplo.dto.ClientDTO;
import com.example.jdbcEjemplo.model.Client;
import org.springframework.stereotype.Service;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService implements ClientDAO {
    @Override
    public List<Client> getClients() throws SQLException, ClassNotFoundException {
        BdConnect.conectar();
        String sqlgetClient="Select * from client";
        Statement st=BdConnect.conectar().createStatement();
        ResultSet rs=st.executeQuery(sqlgetClient);
        List<Client> clients=new ArrayList<Client>();
        while(rs.next()){
            Client client=new Client();
            client.setId(rs.getInt("id"));
            client.setName(rs.getString("name"));
            client.setPhone(rs.getString("phone"));
            clients.add(client);
        }

        return clients;
    }

    @Override
    public Client createClient(Client client) throws SQLException, ClassNotFoundException {
        BdConnect.conectar();
        String sqlInsertarClient="Insert into client(name,phone) values(?,?)";
        PreparedStatement ps=BdConnect.conectar().prepareStatement(sqlInsertarClient);
        ps.setString(1,client.getName());
        ps.setString(2,client.getPhone());

        ps.executeUpdate();

        return client;

    }

    @Override
    public List<Client> getClientById(Integer id) throws SQLException, ClassNotFoundException {
        BdConnect.conectar();
        String sqlid="{CALL getClienteID(?)}";
        CallableStatement cs=BdConnect.conectar().prepareCall(sqlid);
        cs.setInt("c_id",id);
        ResultSet rs=BdConnect.ejecutarprocalmacenado(cs);
        List<Client> clients=new ArrayList<Client>();
        while (rs.next()){
                Client client=new Client();
                client.setId(rs.getInt("id"));
                client.setName(rs.getString("name"));
                client.setPhone(rs.getString("phone"));

                clients.add(client);
            }
        return clients;
    }


}
