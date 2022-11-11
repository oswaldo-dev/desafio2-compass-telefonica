package br.com.tlf.dip.productinventory.productmanagement.application.service;

import br.com.tlf.dip.productinventory.productmanagement.application.ports.in.ProductCrudService;
import br.com.tlf.dip.productinventory.productmanagement.application.ports.out.ProductRepository;
import br.com.tlf.dip.productinventory.productmanagement.domain.dto.RequestProductDto;
import br.com.tlf.dip.productinventory.productmanagement.domain.dto.ResponseProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class ProductService implements ProductCrudService {

    @Autowired
    private ProductRepository repository;

    @Override
    public ResponseEntity<List<ResponseProductDto>> findAll() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<ResponseProductDto> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public ResponseEntity<List<ResponseProductDto>> search(String query, Double minPrice, Double maxPrice) {
        return repository.search(query, minPrice, maxPrice);
    }

    @Override
    public ResponseEntity<ResponseProductDto> insert(RequestProductDto productDto) {
        return repository.save(productDto);
    }

    @Override
    public ResponseEntity<ResponseProductDto> update(String id, RequestProductDto productDto) {
        return repository.update(id, productDto);
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        return repository.delete(id);
    }


}
