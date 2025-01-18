package com.product.product_service.service;

import com.product.product_service.entity.Product;
import com.product.product_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.bson.types.Binary;

import java.io.IOException;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product uploadProductImage(String id, MultipartFile image) throws IOException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        product.setImage(new Binary(image.getBytes()));
        return productRepository.save(product);
    }
    public byte[] getProductImage(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        Binary image = product.getImage();
        return image != null ? image.getData() : new byte[0];
    }
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    public Product getProduct(String id) {
        return productRepository.findById(id).get();
    }
}