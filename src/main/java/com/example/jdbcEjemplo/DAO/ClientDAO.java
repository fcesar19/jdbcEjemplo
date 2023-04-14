package com.example.jdbcEjemplo.DAO;

import com.example.jdbcEjemplo.dto.ClientDTO;
import com.example.jdbcEjemplo.model.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientDAO {

    //ClientController

    List<Client> getClients() throws SQLException, ClassNotFoundException;
    Client createClient(Client client) throws SQLException, ClassNotFoundException;
    List<Client> getClientById(Integer id) throws SQLException, ClassNotFoundException;



}
