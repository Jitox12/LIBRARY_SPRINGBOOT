package com.library.microlibrary.services.serviceImpl;

import com.library.microlibrary.dao.CategoryDao;
import com.library.microlibrary.dto.categoryDto.CreateCategoryDto;
import com.library.microlibrary.dto.categoryDto.EditCategoryDto;
import com.library.microlibrary.dto.categoryDto.GetCategoryDto;
import com.library.microlibrary.dto.categoryDto.GetCategoryNameDto;
import com.library.microlibrary.entities.CategoryEntity;
import com.library.microlibrary.exceptionsConfig.exceptions.BadRequestException;
import com.library.microlibrary.mappers.CategoryMappers;
import com.library.microlibrary.services.CategoryService;
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
    private final CategoryMappers categoryMappers;

    public CategoryServiceImpl(CategoryDao categoryDao, CategoryMappers categoryMappers) {
        this.categoryDao = categoryDao;
        this.categoryMappers = categoryMappers;
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
            categoryDto = categoryMappers.categoryEntityToGetCategoryDto(category);

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
            categoryDto = categoryMappers.categoryEntityToGetGetCategoryNameDtoDto(category);

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
            categoryDto = categoryList.stream().map(categoryMappers::categoryEntityToGetGetCategoryNameDtoDto).collect(Collectors.toList());

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
            categoryDto = categoryList.stream().map(categoryMappers::categoryEntityToGetCategoryDto).collect(Collectors.toList());

            return categoryDto;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createCategoryService(CreateCategoryDto categoryDto) {
        String returnText = null;
        CategoryEntity category = null;
        GetCategoryDto savedCategoryDto = null;

        try {
            categoryDao.createCategoryDao(categoryDto);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void editCategoryService(EditCategoryDto categoryDto, Integer categoryId) {
        CategoryEntity category = null;
        GetCategoryDto editedCategoryDto = null;

        categoryDto.setCategoryIdDto(categoryId);

        try {
            categoryDao.editCategoryDao(categoryDto);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
