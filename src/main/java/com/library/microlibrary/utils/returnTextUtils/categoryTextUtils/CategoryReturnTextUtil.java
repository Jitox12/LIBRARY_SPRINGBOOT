package com.library.microlibrary.utils.returnTextUtils.categoryTextUtils;

import com.library.microlibrary.dto.categoryDto.GetCategoryDto;

public class CategoryReturnTextUtil {
    public static String createCityText(GetCategoryDto categoryDto){
        String returnText = null;

        returnText = ("***Created a new Category*** \n" +
                "\n   Category Name: ").concat(categoryDto.getCategoryDto()) +
                "\n   Category Id: ".concat(String.valueOf(categoryDto.getCategoryIdDto()));
        return returnText;
    }

    public static String editCityText(GetCategoryDto categoryDto){
        String returnText = null;

        returnText = ("***Edited Category with Id: ".concat(String.valueOf(categoryDto.getCategoryIdDto()) +"***") +
                "\n*Edited Category Name: ".concat(String.valueOf(categoryDto.getCategoryDto())+"*"));

        return returnText;
    }
}
