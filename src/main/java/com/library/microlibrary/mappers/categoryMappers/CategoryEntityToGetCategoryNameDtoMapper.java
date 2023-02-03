package com.library.microlibrary.mappers.categoryMappers;

import com.library.microlibrary.dto.categoryDto.GetCategoryNameDto;
import com.library.microlibrary.entities.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryEntityToGetCategoryNameDtoMapper {
    CategoryEntityToGetCategoryDtoMapper INSTANCE = Mappers.getMapper(CategoryEntityToGetCategoryDtoMapper.class);

    @Mapping(source = "categoryName", target = "categoryNameDto")
    GetCategoryNameDto categoryEntityToGetGetCategoryNameDtoDto(CategoryEntity category);

}
