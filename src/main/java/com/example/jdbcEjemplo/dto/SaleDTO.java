package com.example.jdbcEjemplo.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class SaleDTO {
    private int idClient;
    private ArrayList<SaleDetailDTO> saleDetailsDTO;

}
