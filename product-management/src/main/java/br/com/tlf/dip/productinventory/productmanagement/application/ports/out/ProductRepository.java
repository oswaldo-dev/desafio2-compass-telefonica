package br.com.tlf.dip.productinventory.productmanagement.application.ports.out;

import br.com.tlf.dip.productinventory.productmanagement.domain.dto.RequestProductDto;
import br.com.tlf.dip.productinventory.productmanagement.domain.dto.ResponseProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

public interface ProductRepository {

    ResponseEntity<ResponseProductDto> save(RequestProductDto productDto);

    ResponseEntity<List<ResponseProductDto>> findAll();

    ResponseEntity<ResponseProductDto> findById(String id);

    ResponseEntity<ResponseProductDto> update( String id, RequestProductDto productDto);

    ResponseEntity<List<ResponseProductDto>> search(String query, Double minPrice, Double maxPrice);

    ResponseEntity<Void> delete(String id);

}
