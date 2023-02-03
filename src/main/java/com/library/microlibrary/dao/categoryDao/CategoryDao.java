package com.library.microlibrary.dao.categoryDao;


import com.library.microlibrary.dto.categoryDto.CreateCategoryDto;
import com.library.microlibrary.dto.categoryDto.EditCategoryDto;
import com.library.microlibrary.entities.CategoryEntity;

import java.util.List;

public interface CategoryDao {

    public CategoryEntity findCategoryByIdDao(Integer categoryId);
    public List<CategoryEntity> findCategoryListDao();
    public CategoryEntity createCategoryDao(CreateCategoryDto categoryDto);
    public CategoryEntity editCategoryDao(EditCategoryDto categoryDto);
}
