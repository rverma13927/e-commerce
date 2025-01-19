package com.product.product_service.controller;

import com.product.product_service.entity.Product;
import com.product.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.ok(createdProduct);
    }

    @PostMapping("/{id}/image")
    public Product uploadProductImage(@PathVariable String id, @RequestParam("image") MultipartFile image) throws IOException {
        return productService.uploadProductImage(id, image);
    }
    @GetMapping("/{id}/image")
    public ResponseEntity<byte[]> getProductImage(@PathVariable String id) {
        byte[] image = productService.getProductImage(id);
        return ResponseEntity.ok().body(image);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductId(@PathVariable String id) {

        return ResponseEntity.ok().body( productService.getProduct(id));
    }
}