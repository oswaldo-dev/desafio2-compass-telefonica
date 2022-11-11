package br.com.tlf.dip.productinventory.productmanagement.framework.adapters.in;

import br.com.tlf.dip.productinventory.productmanagement.application.service.ProductService;
import br.com.tlf.dip.productinventory.productmanagement.domain.dto.RequestProductDto;
import br.com.tlf.dip.productinventory.productmanagement.domain.dto.ResponseProductDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ProductController.class)
class ProductControllerTest {

    private static final String ID = "1";
    private static final String NAME = "test";
    private static final String DESCRIPTION = "description test";
    private static final Double PRICE = 1232.3;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private ProductService service;


    @Test
    void created() throws Exception {
        final var productSave = RequestProductDto.builder()
                .name(NAME)
                .description(DESCRIPTION)
                .price(PRICE)
                .build();
        final var productResponse = ResponseProductDto.builder()
                .id(ID)
                .name(NAME)
                .description(DESCRIPTION)
                .price(PRICE)
                .build();

        when(service.insert(productSave)).thenReturn(productResponse);
        this.mockMvc.perform(
                post("/productInventory/productManagement/v1/products")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(productSave)))
                .andDo(print())
                .andExpect(status().isCreated());

    }
}