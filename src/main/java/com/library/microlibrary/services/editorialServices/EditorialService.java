package com.library.microlibrary.services.editorialServices;

import com.library.microlibrary.dto.cityDto.GetCityDto;
import com.library.microlibrary.dto.editorialDto.CreateEditorialDto;
import com.library.microlibrary.dto.editorialDto.EditEditorialDto;
import com.library.microlibrary.dto.editorialDto.GetEditorialDto;
import com.library.microlibrary.entities.EditorialEntity;

import java.util.List;

public interface EditorialService {


    public GetEditorialDto findEditorialByIdService(Integer editorialId);
    public List<GetEditorialDto> findEditorialListService();
    public String createEditorialService(CreateEditorialDto editorialDto);
    public String editEditorialService(EditEditorialDto editorialDto, Integer editorialId);
}
