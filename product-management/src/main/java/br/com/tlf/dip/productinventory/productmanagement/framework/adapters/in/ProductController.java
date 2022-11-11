package br.com.tlf.dip.productinventory.productmanagement.framework.adapters.in;

import br.com.tlf.dip.productinventory.productmanagement.application.service.ProductService;
import br.com.tlf.dip.productinventory.productmanagement.domain.dto.RequestProductDto;
import br.com.tlf.dip.productinventory.productmanagement.domain.dto.ResponseProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/productInventory/productManagement/v1/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<ResponseProductDto> post(@Valid @RequestBody RequestProductDto productDto) {
       return service.insert(productDto);
    }

    @GetMapping
    public ResponseEntity<List<ResponseProductDto>> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseProductDto> getById(@PathVariable String id) {
        return service.findById(id);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ResponseProductDto>> search(@RequestParam(value = "min_price", defaultValue = "") Double minPrice,
                                                           @RequestParam(value = "max_price", defaultValue = "") Double maxPrice,
                                                           @RequestParam(value = "q", defaultValue = "") String query) {
        return service.search(query, minPrice, maxPrice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseProductDto> update(@PathVariable String id, @RequestBody @Valid RequestProductDto productDto) {
        return service.update(id, productDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return service.delete(id);
    }

}
