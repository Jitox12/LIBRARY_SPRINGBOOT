package com.library.microlibrary.services.editorialServices;

import com.library.microlibrary.dto.cityDto.GetCityDto;
import com.library.microlibrary.dto.editorialDto.CreateEditorialDto;
import com.library.microlibrary.dto.editorialDto.EditEditorialDto;
import com.library.microlibrary.entities.EditorialEntity;

import java.util.List;

public interface EditorialService {


    public EditorialEntity findEditorialByIdService(Integer editorialId);
    public List<EditorialEntity> findEditorialListService();
    public void createEditorialService(CreateEditorialDto editorialDto);
    public void editEditorialService(EditEditorialDto editorialDto, Integer editorialId);
}
