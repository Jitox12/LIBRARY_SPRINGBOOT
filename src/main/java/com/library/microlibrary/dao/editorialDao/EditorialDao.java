package com.library.microlibrary.dao.editorialDao;

import com.library.microlibrary.dto.cityDto.GetCityDto;
import com.library.microlibrary.dto.editorialDto.CreateEditorialDto;
import com.library.microlibrary.dto.editorialDto.EditEditorialDto;
import com.library.microlibrary.entities.EditorialEntity;

import java.util.List;

public interface EditorialDao {

    public EditorialEntity findEditorialByIdDao(Integer editorialId);
    public List<EditorialEntity> findEditorialListDao();
    public void createEditorialDao(CreateEditorialDto editorialDto, GetCityDto cityDto);
    public void editEditorialDao(EditEditorialDto editorialDto, GetCityDto cityDto);
}
