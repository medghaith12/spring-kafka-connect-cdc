package com.kafka.cdc.controller;

import com.kafka.cdc.dto.ProductDTO;
import com.kafka.cdc.entities.Product;
import com.kafka.cdc.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/products")
public class ProductController {

    private final ProductService service;

    private final ModelMapper modelMapper;


    @GetMapping
    public ResponseEntity<Page<ProductDTO>> getAllProducts(Pageable pagebale) {
        Page<Product> products = service.getAllProducts(pagebale);

        Page<ProductDTO> productDTOPage = products.map(product -> modelMapper.map(product, ProductDTO.class));

        return ResponseEntity.ok(productDTOPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable int id) {
        Product product = service.getProduct(id);

        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);

        return ResponseEntity.ok(productDTO);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO product) {
        Product productRequest = modelMapper.map(product, Product.class);
        Product savedProduct = service.addProduct(productRequest);
        ProductDTO productResponse = modelMapper.map(savedProduct, ProductDTO.class);
        return ResponseEntity.ok(productResponse);
    }

    @PutMapping
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO product) {
        Product productRequest = modelMapper.map(product, Product.class);
        Product updatedProduct = service.updateProduct(productRequest);
        ProductDTO productResponse = modelMapper.map(updatedProduct, ProductDTO.class);
        return ResponseEntity.ok(productResponse);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        service.deleteProduct(id);
    }
}
