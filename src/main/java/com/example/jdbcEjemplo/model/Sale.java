package com.example.jdbcEjemplo.model;

import com.example.jdbcEjemplo.dto.SaleDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sale {
    private int id;
    private Client idClient;
    private double total;
    private List<SaleDetail> saleDetails;
    public Sale(SaleDTO saleDTO, List<SaleDetail> saleDetails){
        Client client=new Client();
        client.setId(saleDTO.getIdClient());
        this.idClient=client;
        double total=0.0;
        for(int i=0;i<saleDetails.size();i++){
            total+=saleDTO.getSaleDetailsDTO().get(i).getQuantity()*saleDetails.get(i).getProduct().getCost();
        }
        this.total=total;
    }


}
