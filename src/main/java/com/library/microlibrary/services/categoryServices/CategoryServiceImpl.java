package com.library.microlibrary.services.categoryServices;

import com.library.microlibrary.dao.categoryDao.CategoryDao;
import com.library.microlibrary.dto.categoryDto.CreateCategoryDto;
import com.library.microlibrary.dto.categoryDto.EditCategoryDto;
import com.library.microlibrary.dto.categoryDto.GetCategoryDto;
import com.library.microlibrary.dto.categoryDto.GetCategoryNameDto;
import com.library.microlibrary.entities.CategoryEntity;
import com.library.microlibrary.mappers.categoryMappers.CategoryEntityToGetCategoryDtoMapper;
import com.library.microlibrary.mappers.categoryMappers.CategoryEntityToGetCategoryNameDtoMapper;
import com.library.microlibrary.utils.returnTextUtils.CategoryTextUtils.CategoryReturnTextUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService{

    //DAO
    private final CategoryDao categoryDao;

    //MAPPERS
    private final CategoryEntityToGetCategoryDtoMapper categoryEntityToGetCategoryDtoMapper;
    private final CategoryEntityToGetCategoryNameDtoMapper categoryEntityToGetCategoryNameDtoMapper;


    @Override
    public GetCategoryDto findCategoryByIdService(Integer categoryId) {
        CategoryEntity category = null;
        GetCategoryDto categoryDto = null;

        category = categoryDao.findCategoryByIdDao(categoryId);
        categoryDto = categoryEntityToGetCategoryDtoMapper.categoryEntityToGetCategoryDto(category);

        return categoryDto;
    }

    @Override
    public GetCategoryNameDto findCategoryNameByIdService(Integer categoryId) {
        CategoryEntity category = null;
        GetCategoryNameDto categoryDto = null;

        category = categoryDao.findCategoryByIdDao(categoryId);
        categoryDto = categoryEntityToGetCategoryNameDtoMapper.categoryEntityToGetGetCategoryNameDtoDto(category);

        return categoryDto;
    }

    @Override
    public List<GetCategoryNameDto> findCategoryNameListService() {
        List<CategoryEntity> categoryList = null;
        List<GetCategoryNameDto> categoryDto = null;

        categoryList = categoryDao.findCategoryListDao();
        categoryDto = categoryList.stream().map(categoryEntityToGetCategoryNameDtoMapper::categoryEntityToGetGetCategoryNameDtoDto).collect(Collectors.toList());

        return categoryDto;
    }
    @Override
    public List<GetCategoryDto> findCategoryListService() {
        List<CategoryEntity> categoryList = null;
        List<GetCategoryDto> categoryDto = null;

        categoryList = categoryDao.findCategoryListDao();
        categoryDto = categoryList.stream().map(categoryEntityToGetCategoryDtoMapper::categoryEntityToGetCategoryDto).collect(Collectors.toList());

        return categoryDto;
    }

    @Override
    public String createCategoryService(CreateCategoryDto categoryDto) {
        String returnText = null;
        CategoryEntity category = null;
        GetCategoryDto savedCategoryDto = null;

        category = categoryDao.createCategoryDao(categoryDto);
        savedCategoryDto = categoryEntityToGetCategoryDtoMapper.categoryEntityToGetCategoryDto(category);

        returnText = CategoryReturnTextUtil.createCityText(savedCategoryDto);

        return returnText;

    }

    @Override
    public String editCategoryService(EditCategoryDto categoryDto, Integer categoryId) {
        String returnText = null;
        CategoryEntity category = null;
        GetCategoryDto editedCategoryDto = null;

        categoryDto.setCategoryIdDto(categoryId);

        category = categoryDao.editCategoryDao(categoryDto);
        editedCategoryDto = categoryEntityToGetCategoryDtoMapper.categoryEntityToGetCategoryDto(category);

        returnText = CategoryReturnTextUtil.editCityText(editedCategoryDto);

        return returnText;
    }
}
