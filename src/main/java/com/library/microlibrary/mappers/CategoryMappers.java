package com.library.microlibrary.mappers;

import com.library.microlibrary.dto.categoryDto.GetCategoryDto;
import com.library.microlibrary.dto.categoryDto.GetCategoryNameDto;
import com.library.microlibrary.entities.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMappers {
    CategoryMappers INSTANCE = Mappers.getMapper(CategoryMappers.class);

    @Mapping(source = "categoryId", target = "categoryIdDto")
    @Mapping(source = "categoryName", target = "categoryNameDto")
    GetCategoryDto categoryEntityToGetCategoryDto(CategoryEntity category);

    @Mapping(source = "categoryName", target = "categoryNameDto")
    GetCategoryNameDto categoryEntityToGetGetCategoryNameDtoDto(CategoryEntity category);
}