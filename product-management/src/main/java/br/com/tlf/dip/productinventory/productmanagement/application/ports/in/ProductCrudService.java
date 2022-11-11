package br.com.tlf.dip.productinventory.productmanagement.application.ports.in;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.tlf.dip.productinventory.productmanagement.domain.dto.RequestProductDto;
import br.com.tlf.dip.productinventory.productmanagement.domain.dto.ResponseProductDto;

public interface ProductCrudService {

    ResponseEntity<List<ResponseProductDto>> findAll();

    ResponseEntity<ResponseProductDto> findById(String id);
    
    ResponseEntity<List<ResponseProductDto>> search(String query, Double minPrice, Double maxPrice);

    ResponseEntity<ResponseProductDto> insert(RequestProductDto productDto);

    ResponseEntity<ResponseProductDto> update(String id, RequestProductDto productDto);

    ResponseEntity<Void> delete(String id);
    
}
