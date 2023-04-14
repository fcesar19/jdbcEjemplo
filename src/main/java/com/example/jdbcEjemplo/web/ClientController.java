package com.example.jdbcEjemplo.web;


import com.example.jdbcEjemplo.bussines.ClientService;
import com.example.jdbcEjemplo.dto.ClientDTO;
import com.example.jdbcEjemplo.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/v1/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("")
    public List<Client> getClient() throws SQLException, ClassNotFoundException {
        return clientService.getClients();
    }
    @GetMapping("/{id}")
    public List<Client> getClientById(@PathVariable int id) throws SQLException, ClassNotFoundException {
        return clientService.getClientById(id);
    }

    @PostMapping("")
    public Client createClient(@RequestBody Client client) throws SQLException, ClassNotFoundException {
        return clientService.createClient(client);

    }


}
