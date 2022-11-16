package br.com.tlf.dip.productinventory.productmanagement.domain.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class RequestProductDto {

    @NotBlank
    private final String name;
    @NotBlank
    private final String description;
    @NotNull
    private final Double price;
}
