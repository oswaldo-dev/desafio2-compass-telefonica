package br.com.tlf.dip.productinventory.productmanagement.framework.adapters.out;

import br.com.tlf.dip.productinventory.productmanagement.application.ports.out.ProductRepository;
import br.com.tlf.dip.productinventory.productmanagement.domain.dto.RequestProductDto;
import br.com.tlf.dip.productinventory.productmanagement.domain.dto.ResponseProductDto;
import br.com.tlf.dip.productinventory.productmanagement.framework.adapters.out.HTTP.CatalogClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Component
public class ProductRepositoryImp implements ProductRepository {

    @Autowired
    private CatalogClient catalogClient;

    @Override
    public ResponseEntity<ResponseProductDto> save(RequestProductDto productDto) {
        ResponseProductDto productSave = catalogClient.save(productDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(productSave.getId())
                .toUri();
        return ResponseEntity.created(uri).body(productSave);
    }

    @Override
    public ResponseEntity<List<ResponseProductDto>> findAll() {
        List<ResponseProductDto> all = catalogClient.findAll();
        return ResponseEntity.ok(all);
    }

    @Override
    public ResponseEntity<ResponseProductDto> findById(String id) {
        ResponseProductDto product = catalogClient.findById(id);
        return ResponseEntity.ok(product);
    }

    @Override
    public ResponseEntity<ResponseProductDto> update(String id, RequestProductDto productDto) {
        ResponseProductDto product = catalogClient.update(id, productDto);
        return ResponseEntity.ok(product);
    }

    @Override
    public ResponseEntity<List<ResponseProductDto>> search(String query, Double minPrice, Double maxPrice) {
        List<ResponseProductDto> search = catalogClient.search(minPrice, maxPrice, query);
        return ResponseEntity.ok(search);
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        catalogClient.delete(id);
        return ResponseEntity.noContent().build();
    }
}
