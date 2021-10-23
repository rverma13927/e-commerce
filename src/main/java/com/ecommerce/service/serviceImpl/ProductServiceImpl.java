package com.ecommerce.service.serviceImpl;

import com.ecommerce.Repository.ProductRepository;
import com.ecommerce.dto.RequestDto.ProductRequestDto;
import com.ecommerce.dto.ResponseMessageDto;
import com.ecommerce.entity.Category;
import com.ecommerce.entity.Customer;
import com.ecommerce.entity.Product;
import com.ecommerce.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Product findProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public ResponseMessageDto saveProduct(ProductRequestDto productRequestDto) {
        Category category = new Category(); category.setCategory_id(productRequestDto.getCategory());
        Product product = new Product(productRequestDto.getProduct_name(),productRequestDto.getPrice(),productRequestDto.getFeatures(),new Date(),category);
        product.setCreated_at(new Date());
        productRepository.save(product);
        return new ResponseMessageDto("Product is saved",true);
    }

    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findAllProductByCategory(Integer category_id) {
        Category category = new Category();
        category.setCategory_id(category_id);
        List<Product> byCategory = productRepository.findByCategory(category);
        System.out.println("Category" + byCategory.get(0).getCategory().getCategory_name());
        return byCategory;
    }
}
