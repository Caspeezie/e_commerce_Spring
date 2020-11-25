package com.ecommerce.data.repository;

import com.ecommerce.data.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    Product product;

    @BeforeEach
    void setUp() {
        product = new Product();
    }

    @Test
    void testWeCanCreateAproduct () {
        product.setName("Garlic");
        product.setPrice(200.00);
        product.setDescription("Garlic creates antibodies");
        product.setExpDate("12/12/2022");
        product.setQuantity(1500);

        productRepository.save(product);
        assertThat(product.getId()).isNotNull();
    }
}