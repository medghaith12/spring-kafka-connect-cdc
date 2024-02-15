package com.kafka.cdc.service;

import com.kafka.cdc.entities.Product;
import com.kafka.cdc.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    @Override
    public Product addProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public Page<Product> getAllProducts(Pageable pagebale) {
        return repository.findAll(pagebale);
    }

    @Override
    public Product getProduct(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteProduct(int id) {
        repository.deleteById(id);
    }
}
