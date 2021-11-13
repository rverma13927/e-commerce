package com.ecommerce.service.serviceImpl;

import com.ecommerce.dto.RequestDto.ProductRequestDto;
import com.ecommerce.dto.ResponseMessageDto;
import com.ecommerce.entity.Category;
import com.ecommerce.entity.Product;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // sl4j abstraction
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    //some of the feature you can use in below log4j2
//private static final Logger logger = LogManager.getLogger(ProductService.class);

    @Override
    public Product findProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public ResponseMessageDto saveProduct(ProductRequestDto productRequestDto) {
        Category category = new Category();
        category.setCategory_id(productRequestDto.getCategory());
        Product product = new Product(productRequestDto.getProduct_name(), productRequestDto.getPrice(), productRequestDto.getFeatures(), new Date(), category);
        product.setCreated_at(new Date());
        productRepository.save(product);
        return new ResponseMessageDto("Product is saved", true);
    }

    @Override
    public List<Product> findAllProduct() {
        logger.info("Inside the all product find service");
        return productRepository.findAll();
    }

    @Override
    public List<Product> findAllProductByCategory(Integer categoryId) {
        Category category = new Category();
        category.setCategory_id(categoryId);
        return productRepository.findByCategory(category);
    }
}
