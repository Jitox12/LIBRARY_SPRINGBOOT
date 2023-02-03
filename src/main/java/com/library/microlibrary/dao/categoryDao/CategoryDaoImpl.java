package com.library.microlibrary.dao.categoryDao;

import com.library.microlibrary.dto.categoryDto.CreateCategoryDto;
import com.library.microlibrary.dto.categoryDto.EditCategoryDto;
import com.library.microlibrary.entities.CategoryEntity;
import com.library.microlibrary.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class CategoryDaoImpl implements CategoryDao{

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryEntity findCategoryByIdDao(Integer categoryId) {
        CategoryEntity category = null;
        category = categoryRepository.findByCategoryId(categoryId);

        return category;
    }

    @Override
    public List<CategoryEntity> findCategoryListDao() {
        List<CategoryEntity> categoryList = null;
        categoryList = categoryRepository.findAll();

        return categoryList;
    }

    @Override
    public CategoryEntity createCategoryDao(CreateCategoryDto categoryDto) {
        CategoryEntity category = null;
        CategoryEntity savedCategory = null;

        category = CategoryEntity.builder()
                .categoryName(categoryDto.getCategoryNameDto())
                .build();

        savedCategory = categoryRepository.save(category);

        return savedCategory;
    }

    @Override
    public CategoryEntity editCategoryDao(EditCategoryDto categoryDto) {
        CategoryEntity category = null;
        CategoryEntity editedCategory = null;

        category = CategoryEntity.builder()
                .categoryId(categoryDto.getCategoryIdDto())
                .categoryName(categoryDto.getCategoryNameDto())
                .build();

        editedCategory = categoryRepository.save(category);

        return editedCategory;
    }
}
