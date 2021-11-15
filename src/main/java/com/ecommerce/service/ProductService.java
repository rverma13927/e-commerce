package com.ecommerce.service;

import com.ecommerce.dto.RequestDto.ProductRequestDto;
import com.ecommerce.dto.ResponseMessageDto;
import com.ecommerce.entity.Product;

import java.util.List;

public interface ProductService {


    Product findProductById(Integer id);

    ResponseMessageDto saveProduct(ProductRequestDto product);

    List<Product> findAllProduct();

    List<Product> findAllProductByCategory(Integer categoryId);
}
