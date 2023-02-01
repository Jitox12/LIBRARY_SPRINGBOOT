package com.library.microlibrary.dao.editorialDao;

import com.library.microlibrary.dto.cityDto.GetCityDto;
import com.library.microlibrary.dto.editorialDto.CreateEditorialDto;
import com.library.microlibrary.dto.editorialDto.EditEditorialDto;
import com.library.microlibrary.entities.EditorialEntity;
import com.library.microlibrary.repositories.EditorialRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class EditorialDaoImpl implements EditorialDao{

    private final EditorialRepository editorialRepository;

    @Override
    public EditorialEntity findEditorialByIdDao(Integer editorialId) {
        return null;
    }

    @Override
    public List<EditorialEntity> findEditorialListDao() {
        return null;
    }

    @Override
    public void createEditorialDao(CreateEditorialDto editorialDto, GetCityDto cityDto) {

    }

    @Override
    public void editEditorialDao(EditEditorialDto editorialDto, GetCityDto cityDto) {

    }
}
