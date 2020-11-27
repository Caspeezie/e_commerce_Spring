package com.ecommerce.service.product;

import com.ecommerce.data.model.Product;
import com.ecommerce.data.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService = new ProductServiceImpl();

    Product product;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        product = new Product();
    }

    @Test
    void testThatWeCanCallTheSaveProductRepository () {
        when(productRepository.save(product)).thenReturn(product);
        productService.saveProduct(product);
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void testWeCanCallTheFindProductByIdRespository () {
        when(productRepository.findById(2)).thenReturn(Optional.of(product));
        productService.findProductById(2);
        verify(productRepository, times(1)).findById(2);
    }

    @Test
    void testWeCanCallTheDeleteProductByIdRepository () {
        doNothing().when(productRepository).deleteById(2);
        productService.deleteProductById(2);
        verify(productRepository, times(1)).deleteById(2);
    }

    @Test
    void testWeCanCallTheFindAllProductRepository () {
        List<Product> productList = new ArrayList<>();

        when(productRepository.findAll()).thenReturn(productList);
        productService.findAllProduct();
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testWeCanCallTheUpdateProductRepository () {
        when(productRepository.save(product)).thenReturn(product);
        productService.updateProduct(product);
        verify(productRepository, times(1)).save(product);
    }

}