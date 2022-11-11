package br.com.tlf.dip.productinventory.productmanagement.application.ports.in;

import br.com.tlf.dip.productinventory.productmanagement.domain.dto.RequestProductDto;
import br.com.tlf.dip.productinventory.productmanagement.domain.dto.ResponseProductDto;

import java.util.List;

public interface ProductCrudService {

    List<ResponseProductDto> findAll();

    ResponseProductDto findById(String id);
    
    List<ResponseProductDto> search(String query, Double minPrice, Double maxPrice);

    ResponseProductDto insert(RequestProductDto productDto);

    ResponseProductDto update(String id, RequestProductDto productDto);

    void delete(String id);
    
}
