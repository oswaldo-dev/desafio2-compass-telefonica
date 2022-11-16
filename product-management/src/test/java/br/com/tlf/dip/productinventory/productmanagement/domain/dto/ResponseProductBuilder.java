package br.com.tlf.dip.productinventory.productmanagement.domain.dto;

import lombok.Builder;

@Builder
public class ResponseProductBuilder {

    @Builder.Default
    private final String ID = "1";
    @Builder.Default
    private final String NAME = "test";
    @Builder.Default
    private final String DESCRIPTION = "description test";
    @Builder.Default
    private final Double PRICE = 1232.3;

    public ResponseProductDto toResponseProductDto() {
        return new ResponseProductDto(ID,
                NAME,
                DESCRIPTION,
                PRICE);
    }

    public RequestProductDto toRequestProductDto() {
        return new RequestProductDto(NAME,
                DESCRIPTION,
                PRICE);
    }

}