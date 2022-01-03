package com.ecommerce.service.serviceImpl;

import com.ecommerce.dto.ResponseMessageDto;
import com.ecommerce.entity.Category;
import com.ecommerce.repository.CategoryRepository;
import com.ecommerce.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;


    @PersistenceContext
    private EntityManager entityManager;
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional
    public ResponseMessageDto saveCategory(Category category) {
          entityManager.merge(category);
//          entityManager.
//         categoryRepository.save(category);
        return new ResponseMessageDto("Category saved successfully",true);
    }
}
