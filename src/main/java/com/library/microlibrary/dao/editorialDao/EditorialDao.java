package com.library.microlibrary.dao.editorialDao;

import com.library.microlibrary.dto.cityDto.GetCityCountryDto;
import com.library.microlibrary.dto.cityDto.GetCityDto;
import com.library.microlibrary.dto.countryDto.GetCountryDto;
import com.library.microlibrary.dto.editorialDto.CreateEditorialDto;
import com.library.microlibrary.dto.editorialDto.EditEditorialDto;
import com.library.microlibrary.entities.EditorialEntity;

import java.util.List;

public interface EditorialDao {

    public EditorialEntity findEditorialNameByIdDao(Integer editorialId);
    EditorialEntity findEditorialByIdDao(Integer editorialId);
    public List<EditorialEntity> findEditorialListDao();
    public EditorialEntity createEditorialDao(CreateEditorialDto editorialDto, GetCityCountryDto cityDto);
    public EditorialEntity editEditorialDao(EditEditorialDto editorialDto, GetCityCountryDto cityDto);
}
