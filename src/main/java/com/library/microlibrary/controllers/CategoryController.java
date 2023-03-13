package com.library.microlibrary.controllers;

import com.library.microlibrary.dto.categoryDto.CreateCategoryDto;
import com.library.microlibrary.dto.categoryDto.EditCategoryDto;
import com.library.microlibrary.dto.categoryDto.GetCategoryDto;
import com.library.microlibrary.dto.categoryDto.GetCategoryNameDto;
import com.library.microlibrary.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping(value = "/find-name/{categoryId}")
    public GetCategoryNameDto findCategoryNameById(@PathVariable Integer categoryId){
        GetCategoryNameDto categoryNameDto = null;
        categoryNameDto = categoryService.findCategoryNameByIdService(categoryId);

        return categoryNameDto;
    }
    @GetMapping(value = "/find/{categoryId}")
    public GetCategoryDto findCategoryById(@PathVariable Integer categoryId){
        GetCategoryDto categoryDto = null;
        categoryDto = categoryService.findCategoryByIdService(categoryId);
        return categoryDto;
    }

    @GetMapping(value = "/find-name-list")
    public List<GetCategoryNameDto> findCategoryNameList(){
        List<GetCategoryNameDto> categoryNameListDto = null;
        categoryNameListDto = categoryService.findCategoryNameListService();

        return categoryNameListDto;
    }

    @GetMapping(value = "/find-list")
    public List<GetCategoryDto> findCategoryList(){
        List<GetCategoryDto> categoryListDto = null;
        categoryListDto = categoryService.findCategoryListService();

        return categoryListDto;
    }

    @PostMapping(value="/create")
    public String createCategory(@RequestBody CreateCategoryDto createCategoryDto){
        categoryService.createCategoryService(createCategoryDto);

        return "CATEGORY CREATED";
    }

    @PutMapping(value="/edit/{categoryId}")
    public String editCategory(@RequestBody EditCategoryDto editCategoryDto, @PathVariable Integer categoryId){
        categoryService.editCategoryService(editCategoryDto, categoryId);

        return "CATEGORY EDITED";
    }

}
