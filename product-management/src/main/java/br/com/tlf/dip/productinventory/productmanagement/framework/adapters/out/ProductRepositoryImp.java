package br.com.tlf.dip.productinventory.productmanagement.framework.adapters.out;

import br.com.tlf.dip.productinventory.productmanagement.application.ports.out.ProductRepository;
import br.com.tlf.dip.productinventory.productmanagement.domain.dto.RequestProductDto;
import br.com.tlf.dip.productinventory.productmanagement.domain.dto.ResponseProductDto;
import br.com.tlf.dip.productinventory.productmanagement.framework.adapters.out.HTTP.CatalogClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductRepositoryImp implements ProductRepository {

    private final CatalogClient catalogClient;

    @Override
    public ResponseProductDto save(RequestProductDto productDto) {
        return catalogClient.save(productDto);
    }

    @Override
    public List<ResponseProductDto> findAll() {
        return catalogClient.findAll();
    }

    @Override
    public ResponseProductDto findById(String id) {
        return catalogClient.findById(id);
    }

    @Override
    public ResponseProductDto update(String id, RequestProductDto productDto) {
        return catalogClient.update(id, productDto);
    }

    @Override
    public List<ResponseProductDto> search(String query, Double minPrice, Double maxPrice) {
        return catalogClient.search(minPrice, maxPrice, query);

    }

    @Override
    public void delete(String id) {
        catalogClient.delete(id);
    }
}
