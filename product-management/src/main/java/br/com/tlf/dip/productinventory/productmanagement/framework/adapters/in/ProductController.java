package br.com.tlf.dip.productinventory.productmanagement.framework.adapters.in;

import br.com.tlf.dip.productinventory.productmanagement.application.service.ProductService;
import br.com.tlf.dip.productinventory.productmanagement.domain.dto.RequestProductDto;
import br.com.tlf.dip.productinventory.productmanagement.domain.dto.ResponseProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/productInventory/productManagement/v1/products")
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<ResponseProductDto> post(@Valid @RequestBody RequestProductDto productDto) {
        ResponseProductDto productSave = service.insert(productDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(productSave.getId())
                .toUri();
        return ResponseEntity.created(uri).body(productSave);
    }

    @GetMapping
    public ResponseEntity<List<ResponseProductDto>> getAll() {
        List<ResponseProductDto> products = service.findAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseProductDto> getById(@PathVariable String id) {
        ResponseProductDto product = service.findById(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ResponseProductDto>> search(@RequestParam(value = "min_price", defaultValue = "") Double minPrice,
                                                           @RequestParam(value = "max_price", defaultValue = "") Double maxPrice,
                                                           @RequestParam(value = "q", defaultValue = "") String query) {
        List<ResponseProductDto> products = service.search(query, minPrice, maxPrice);
        return ResponseEntity.ok(products);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseProductDto> update(@PathVariable String id, @RequestBody @Valid RequestProductDto productDto) {
        ResponseProductDto product = service.update(id, productDto);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
