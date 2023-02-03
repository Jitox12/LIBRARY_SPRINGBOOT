package com.library.microlibrary.mappers.categoryMappers;

import com.library.microlibrary.dto.categoryDto.GetCategoryDto;
import com.library.microlibrary.dto.cityDto.GetCityDto;
import com.library.microlibrary.entities.CategoryEntity;
import com.library.microlibrary.entities.CityEntity;
import com.library.microlibrary.mappers.cityMappers.CityEntityToGetCityDtoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryEntityToGetCategoryDtoMapper {
    CategoryEntityToGetCategoryDtoMapper INSTANCE = Mappers.getMapper(CategoryEntityToGetCategoryDtoMapper.class);

    @Mapping(source = "categoryId", target = "categoryIdDto")
    @Mapping(source = "categoryName", target = "categoryDto")
    GetCategoryDto categoryEntityToGetCategoryDto(CategoryEntity category);
}
