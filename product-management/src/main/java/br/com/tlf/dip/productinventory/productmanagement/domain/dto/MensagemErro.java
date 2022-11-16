package br.com.tlf.dip.productinventory.productmanagement.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MensagemErro {

    private List<String> erros;
    private String status;
    private String message;

    public MensagemErro(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public MensagemErro(List<String> erros) {
        this.erros = erros;
    }

}
