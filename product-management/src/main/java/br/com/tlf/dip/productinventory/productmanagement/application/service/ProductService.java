package br.com.tlf.dip.productinventory.productmanagement.application.service;

import br.com.tlf.dip.productinventory.productmanagement.application.ports.in.ProductCrudService;
import br.com.tlf.dip.productinventory.productmanagement.application.ports.out.ProductRepository;
import br.com.tlf.dip.productinventory.productmanagement.domain.dto.RequestProductDto;
import br.com.tlf.dip.productinventory.productmanagement.domain.dto.ResponseProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductCrudService {

    private final ProductRepository repository;

    @Override
    public List<ResponseProductDto> findAll() {
        return repository.findAll();
    }

    @Override
    public ResponseProductDto findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<ResponseProductDto> search(String query, Double minPrice, Double maxPrice) {
        return repository.search(query, minPrice, maxPrice);
    }

    @Override
    public ResponseProductDto insert(RequestProductDto productDto) {
        return repository.save(productDto);
    }

    @Override
    public ResponseProductDto update(String id, RequestProductDto productDto) {
        return repository.update(id, productDto);
    }

    @Override
    public void delete(String id) {
        repository.delete(id);
    }


}
