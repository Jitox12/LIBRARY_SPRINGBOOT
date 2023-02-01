package com.library.microlibrary.services.editorialServices;

import com.library.microlibrary.dto.editorialDto.CreateEditorialDto;
import com.library.microlibrary.dto.editorialDto.EditEditorialDto;
import com.library.microlibrary.entities.EditorialEntity;

import java.util.List;

public class EditorialServiceImpl implements EditorialService{
    @Override
    public EditorialEntity findEditorialByIdService(Integer editorialId) {
        return null;
    }

    @Override
    public List<EditorialEntity> findEditorialListService() {
        return null;
    }

    @Override
    public void createEditorialService(CreateEditorialDto editorialDto) {

    }

    @Override
    public void editEditorialService(EditEditorialDto editorialDto, Integer editorialId) {

    }
}
