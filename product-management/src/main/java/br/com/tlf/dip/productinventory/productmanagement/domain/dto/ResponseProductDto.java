package br.com.tlf.dip.productinventory.productmanagement.domain.dto;

import lombok.*;

@Getter
@AllArgsConstructor
public class ResponseProductDto {
    private final String id;
    private final String name;
    private final String description;
    private final Double price;
}
