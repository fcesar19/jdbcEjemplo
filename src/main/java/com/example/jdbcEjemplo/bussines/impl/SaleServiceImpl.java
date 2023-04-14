package com.example.jdbcEjemplo.bussines.impl;

import com.example.jdbcEjemplo.DAO.ClientDAO;
import com.example.jdbcEjemplo.DAO.ProductDAO;
import com.example.jdbcEjemplo.bussines.SaleService;
import com.example.jdbcEjemplo.dto.SaleDTO;
import com.example.jdbcEjemplo.model.Sale;
import com.example.jdbcEjemplo.model.SaleDetail;
import com.example.jdbcEjemplo.repository.SaleDetailRepository;
import com.example.jdbcEjemplo.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private ClientDAO clientDAO;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SaleDetailRepository saleDetailRepository;

    @Override
    public List<Sale> getSales() {
    return null;
    }

    @Override
    public Sale createSale(SaleDTO saleDTO) {
        return null;
    }
}
