package com.kafka.cdc.service;

import com.kafka.cdc.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    public Product addProduct(Product product);

    public Product updateProduct(Product product);
    public Page<Product> getAllProducts(Pageable pageable);
    public Product getProduct(int id);

    public void deleteProduct(int id);
}
