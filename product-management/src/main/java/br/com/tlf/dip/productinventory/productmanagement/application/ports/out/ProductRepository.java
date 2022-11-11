package br.com.tlf.dip.productinventory.productmanagement.application.ports.out;

import br.com.tlf.dip.productinventory.productmanagement.domain.dto.RequestProductDto;
import br.com.tlf.dip.productinventory.productmanagement.domain.dto.ResponseProductDto;

import java.util.List;

public interface ProductRepository {

    ResponseProductDto save(RequestProductDto productDto);

    List<ResponseProductDto> findAll();

    ResponseProductDto findById(String id);

    ResponseProductDto update( String id, RequestProductDto productDto);

    List<ResponseProductDto> search(String query, Double minPrice, Double maxPrice);

    void delete(String id);

}
