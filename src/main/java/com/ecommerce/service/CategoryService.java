package com.ecommerce.service;

import com.ecommerce.dto.ResponseMessageDto;
import com.ecommerce.entity.Category;

import java.util.List;

public interface CategoryService {


    List<Category> findAllCategory();

    ResponseMessageDto saveCategory(Category category);
}
