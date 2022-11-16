package br.com.tlf.dip.productinventory.productmanagement.framework.adapters.in;

import br.com.tlf.dip.productinventory.productmanagement.application.service.ProductService;
import br.com.tlf.dip.productinventory.productmanagement.domain.dto.RequestProductDto;
import br.com.tlf.dip.productinventory.productmanagement.domain.dto.ResponseProductBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ProductController.class)
class ProductControllerTest {

    private static final String PRODUCT_PATH = "/productInventory/productManagement/v1/products";

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private ProductService service;


    @Test
    void created() throws Exception {
        final var productSave = ResponseProductBuilder.builder().build().toRequestProductDto();
        final var productResponse = ResponseProductBuilder.builder().build().toResponseProductDto();

        when(service.insert(any(RequestProductDto.class))).thenReturn(productResponse);
        this.mockMvc.perform(
                post(PRODUCT_PATH).contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(productSave)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", is(productResponse.getName())))
                .andExpect(jsonPath("$.description", is(productResponse.getDescription())))
                .andExpect(jsonPath("$.price", is(productResponse.getPrice())));


    }

    @Test
    void findAll() throws Exception {
        final var productResponse = ResponseProductBuilder.builder().build().toResponseProductDto();

        when(service.findAll()).thenReturn(Collections.singletonList(productResponse));

        this.mockMvc.perform(
                get(PRODUCT_PATH).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        final var productResponse = ResponseProductBuilder.builder().build().toResponseProductDto();

        when(service.findById("1")).thenReturn(productResponse);

        this.mockMvc.perform(
                        get(PRODUCT_PATH + "/" + productResponse.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(productResponse.getName())))
                .andExpect(jsonPath("$.description", is(productResponse.getDescription())))
                .andExpect(jsonPath("$.price", is(productResponse.getPrice())));
    }

    @Test
    void deleteById() throws Exception {
        final var productResponse = ResponseProductBuilder.builder().build().toResponseProductDto();

        doNothing().when(service).delete(productResponse.getId());

        this.mockMvc.perform(
                delete(PRODUCT_PATH + "/" + productResponse.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}