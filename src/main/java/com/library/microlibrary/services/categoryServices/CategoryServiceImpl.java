package com.library.microlibrary.services.categoryServices;

import com.library.microlibrary.dao.categoryDao.CategoryDao;
import com.library.microlibrary.dto.categoryDto.CreateCategoryDto;
import com.library.microlibrary.dto.categoryDto.EditCategoryDto;
import com.library.microlibrary.dto.categoryDto.GetCategoryDto;
import com.library.microlibrary.dto.categoryDto.GetCategoryNameDto;
import com.library.microlibrary.entities.CategoryEntity;
import com.library.microlibrary.exceptionsConfig.exceptions.BadRequestException;
import com.library.microlibrary.mappers.categoryMappers.CategoryEntityToGetCategoryDtoMapper;
import com.library.microlibrary.mappers.categoryMappers.CategoryEntityToGetCategoryNameDtoMapper;
import com.library.microlibrary.utils.returnTextUtils.categoryTextUtils.CategoryReturnTextUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    //DAO
    private final CategoryDao categoryDao;

    //MAPPERS
    private final CategoryEntityToGetCategoryDtoMapper categoryEntityToGetCategoryDtoMapper;
    private final CategoryEntityToGetCategoryNameDtoMapper categoryEntityToGetCategoryNameDtoMapper;

    public CategoryServiceImpl(CategoryDao categoryDao, CategoryEntityToGetCategoryDtoMapper categoryEntityToGetCategoryDtoMapper, CategoryEntityToGetCategoryNameDtoMapper categoryEntityToGetCategoryNameDtoMapper) {
        this.categoryDao = categoryDao;
        this.categoryEntityToGetCategoryDtoMapper = categoryEntityToGetCategoryDtoMapper;
        this.categoryEntityToGetCategoryNameDtoMapper = categoryEntityToGetCategoryNameDtoMapper;
    }


    @Override
    public GetCategoryDto findCategoryByIdService(Integer categoryId) {
        CategoryEntity category = null;
        GetCategoryDto categoryDto = null;

        try {
            category = categoryDao.findCategoryByIdDao(categoryId);
            if(Objects.isNull(category)){
                throw new BadRequestException("Category does not exist with id: ".concat(String.valueOf(categoryId)));
            }
            categoryDto = categoryEntityToGetCategoryDtoMapper.categoryEntityToGetCategoryDto(category);

            return categoryDto;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public GetCategoryNameDto findCategoryNameByIdService(Integer categoryId) {
        CategoryEntity category = null;
        GetCategoryNameDto categoryDto = null;

        try {
            category = categoryDao.findCategoryByIdDao(categoryId);
            if(Objects.isNull(category)){
                throw new BadRequestException("Category does not exist with id: ".concat(String.valueOf(categoryId)));
            }
            categoryDto = categoryEntityToGetCategoryNameDtoMapper.categoryEntityToGetGetCategoryNameDtoDto(category);

            return categoryDto;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<GetCategoryNameDto> findCategoryNameListService() {
        List<CategoryEntity> categoryList = null;
        List<GetCategoryNameDto> categoryDto = null;

        try {
            categoryList = categoryDao.findCategoryListDao();
            categoryDto = categoryList.stream().map(categoryEntityToGetCategoryNameDtoMapper::categoryEntityToGetGetCategoryNameDtoDto).collect(Collectors.toList());

            return categoryDto;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<GetCategoryDto> findCategoryListService() {
        List<CategoryEntity> categoryList = null;
        List<GetCategoryDto> categoryDto = null;


        try {
            categoryList = categoryDao.findCategoryListDao();
            categoryDto = categoryList.stream().map(categoryEntityToGetCategoryDtoMapper::categoryEntityToGetCategoryDto).collect(Collectors.toList());

            return categoryDto;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String createCategoryService(CreateCategoryDto categoryDto) {
        String returnText = null;
        CategoryEntity category = null;
        GetCategoryDto savedCategoryDto = null;


        try {
            category = categoryDao.createCategoryDao(categoryDto);
            savedCategoryDto = categoryEntityToGetCategoryDtoMapper.categoryEntityToGetCategoryDto(category);

            returnText = CategoryReturnTextUtil.createCityText(savedCategoryDto);

            return returnText;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String editCategoryService(EditCategoryDto categoryDto, Integer categoryId) {
        String returnText = null;
        CategoryEntity category = null;
        GetCategoryDto editedCategoryDto = null;

        categoryDto.setCategoryIdDto(categoryId);

        try {
            category = categoryDao.editCategoryDao(categoryDto);
            editedCategoryDto = categoryEntityToGetCategoryDtoMapper.categoryEntityToGetCategoryDto(category);

            returnText = CategoryReturnTextUtil.editCityText(editedCategoryDto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return returnText;
    }
}
