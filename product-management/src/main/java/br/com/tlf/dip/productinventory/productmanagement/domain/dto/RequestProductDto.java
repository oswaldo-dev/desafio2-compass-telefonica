package br.com.tlf.dip.productinventory.productmanagement.domain.dto;

import lombok.Data;

@Data
public class RequestProductDto {
    
    private String name;
    private String description;
    private Double price;
}
