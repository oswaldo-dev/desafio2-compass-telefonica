package br.com.tlf.dip.productinventory.productmanagement;

import br.com.tlf.dip.productinventory.productmanagement.application.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProductManagementApplicationTests {

	@Autowired
	private ProductService service;

	@Test
	void contextLoads() {
		assertThat(service).isNotNull();
	}

}
