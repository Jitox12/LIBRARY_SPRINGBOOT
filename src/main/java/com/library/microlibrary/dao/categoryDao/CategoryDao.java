package com.library.microlibrary.dao.categoryDao;


import com.library.microlibrary.dto.categoryDto.CreateCategoryDto;
import com.library.microlibrary.dto.categoryDto.EditCategoryDto;
import com.library.microlibrary.entities.CategoryEntity;

import java.io.IOException;
import java.util.List;

public interface CategoryDao {

    public CategoryEntity findCategoryByIdDao(Integer categoryId) throws IOException;
    public List<CategoryEntity> findCategoryListDao() throws IOException;
    public CategoryEntity createCategoryDao(CreateCategoryDto categoryDto) throws IOException;
    public CategoryEntity editCategoryDao(EditCategoryDto categoryDto) throws IOException;
}
