package br.com.tlf.dip.productinventory.productmanagement.framework.adapters.out.HTTP;

import br.com.tlf.dip.productinventory.productmanagement.domain.dto.RequestProductDto;
import br.com.tlf.dip.productinventory.productmanagement.domain.dto.ResponseProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "catalog", url = "http://localhost:9999")
public interface CatalogClient {

    @RequestMapping(method = RequestMethod.POST, value = "/products")
    ResponseProductDto save(RequestProductDto productDto);

    @RequestMapping(method = RequestMethod.GET, value = "/products")
    List<ResponseProductDto> findAll();


    @RequestMapping(method = RequestMethod.GET, value = "/products/{id}")
    ResponseProductDto findById(@PathVariable String id);

    @RequestMapping(method = RequestMethod.PUT, value = "/products/{id}")
    ResponseProductDto update(@PathVariable String id, RequestProductDto productDto);

    @RequestMapping(method = RequestMethod.GET, value = "/products/search")
    List<ResponseProductDto> search(
            @RequestParam(value = "min_price", defaultValue = "") Double minPrice,
            @RequestParam(value = "max_price", defaultValue = "") Double maxPrice,
            @RequestParam(value = "q", defaultValue = "") String q);

    @RequestMapping(method = RequestMethod.DELETE, value = "/products/{id}")
    Void delete(@PathVariable String id);
}
