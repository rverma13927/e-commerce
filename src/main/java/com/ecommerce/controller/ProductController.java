package com.ecommerce.controller;

import com.ecommerce.dto.RequestDto.ProductRequestDto;
import com.ecommerce.dto.ResponseMessageDto;
import com.ecommerce.entity.Product;
import com.ecommerce.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@CrossOrigin("*")
//  https://www.appsdeveloperblog.com/spring-security-preauthorize-annotation-example/
// @PreAuthorize("hasRole('ROLE_CUSTOMER')")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    ResponseEntity<List<Product>> getProduct() {
        return new ResponseEntity<>(productService.findAllProduct(), HttpStatus.OK);
    }

    @GetMapping("category/{category_id}")
    ResponseEntity<List<Product>> getProductByCategoryId(@PathVariable(value = "category_id") Integer categoryId) {
        return new ResponseEntity<>(productService.findAllProductByCategory(categoryId), HttpStatus.OK);
    }

    @GetMapping("{id}")
    ResponseEntity<Product> getProductById(@PathVariable(value = "id") Integer id) {
        return new ResponseEntity<>(productService.findProductById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<ResponseMessageDto> addProduct(@RequestBody ProductRequestDto product) {
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.OK);
    }
}
