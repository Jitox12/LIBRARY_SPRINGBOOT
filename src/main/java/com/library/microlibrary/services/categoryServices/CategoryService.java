package com.library.microlibrary.services.categoryServices;

import com.library.microlibrary.dto.categoryDto.CreateCategoryDto;
import com.library.microlibrary.dto.categoryDto.EditCategoryDto;
import com.library.microlibrary.dto.categoryDto.GetCategoryDto;
import com.library.microlibrary.dto.categoryDto.GetCategoryNameDto;
import com.library.microlibrary.entities.CategoryEntity;

import java.util.List;

public interface CategoryService {

    public GetCategoryDto findCategoryByIdService(Integer categoryId);
    public GetCategoryNameDto findCategoryNameByIdService(Integer categoryId);
    public List<GetCategoryDto> findCategoryListService();
    public List<GetCategoryNameDto> findCategoryNameListService();
    public String createCategoryService(CreateCategoryDto categoryDto);
    public String editCategoryService(EditCategoryDto categoryDto, Integer categoryId);
}
