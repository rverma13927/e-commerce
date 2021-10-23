package com.ecommerce.service.serviceImpl;

import com.ecommerce.Repository.CategoryRepository;
import com.ecommerce.dto.ResponseMessageDto;
import com.ecommerce.entity.Category;
import com.ecommerce.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public ResponseMessageDto saveCategory(Category category) {
         categoryRepository.save(category);
        return new ResponseMessageDto("Category saved successfully",true);
    }
}
