package com.library.microlibrary.dao;

import com.library.microlibrary.dto.bookDto.GABookDto;
import com.library.microlibrary.dto.cityDto.GetCityCountryDto;
import com.library.microlibrary.dto.editorialDto.CreateEditorialDto;
import com.library.microlibrary.dto.editorialDto.EditEditorialDto;
import com.library.microlibrary.entities.EditorialEntity;

import java.io.IOException;
import java.util.List;

public interface EditorialDao {

    public EditorialEntity findEditorialNameByIdDao(Integer editorialId) throws IOException;
    EditorialEntity findEditorialByIdDao(Integer editorialId) throws IOException;
    public List<EditorialEntity> findEditorialListDao() throws IOException;
    public void createEditorialDao(CreateEditorialDto editorialDto, GetCityCountryDto cityDto) throws IOException;
    public void editEditorialDao(EditEditorialDto editorialDto, GetCityCountryDto cityDto) throws IOException;

    public void createBookToEditorialDao(Integer editorialId , List<GABookDto> bookList) throws IOException;

}
