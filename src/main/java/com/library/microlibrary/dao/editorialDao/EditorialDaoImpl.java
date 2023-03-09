package com.library.microlibrary.dao.editorialDao;

import com.library.microlibrary.dto.cityDto.GetCityCountryDto;
import com.library.microlibrary.dto.cityDto.GetCityDto;
import com.library.microlibrary.dto.countryDto.GetCountryDto;
import com.library.microlibrary.dto.editorialDto.CreateEditorialDto;
import com.library.microlibrary.dto.editorialDto.EditEditorialDto;
import com.library.microlibrary.entities.CityEntity;
import com.library.microlibrary.entities.CountryEntity;
import com.library.microlibrary.entities.EditorialEntity;
import com.library.microlibrary.repositories.EditorialRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@Component
public class EditorialDaoImpl implements EditorialDao {

    private final EditorialRepository editorialRepository;

    @Override
    public EditorialEntity findEditorialNameByIdDao(Integer editorialId) throws IOException {
        EditorialEntity editorial = null;
        editorial = editorialRepository.findEditorialNameByEditorialId(editorialId);
        return editorial;
    }
    @Override
    public EditorialEntity findEditorialByIdDao(Integer editorialId) throws IOException{
        EditorialEntity editorial = null;
        editorial = editorialRepository.findEditorialNameByEditorialId(editorialId);
        return editorial;
    }

    @Override
    public List<EditorialEntity> findEditorialListDao() throws IOException{
        List<EditorialEntity> editorialList = null;
        editorialList = editorialRepository.findAll();
        return editorialList;
    }

    @Override
    public void createEditorialDao(CreateEditorialDto editorialDto,
                                              GetCityCountryDto cityDto) throws IOException{
        EditorialEntity editorial = null;
        CityEntity city = null;

        city = CityEntity.builder()
                .cityName(cityDto.getCityNameDto())
                .cityId(cityDto.getCityIdDto())
                .country(cityDto.getCountryDto())
                .build();

        editorial = EditorialEntity.builder()
                .editorialName(editorialDto.getEditorialNameDto())
                .city(city)
                .build();

         editorialRepository.save(editorial);

    }

    @Override
    public void editEditorialDao(EditEditorialDto editorialDto,
                                            GetCityCountryDto cityDto) throws IOException{
        EditorialEntity editorial = null;
        CityEntity city = null;

        city = CityEntity.builder()
                .cityName(cityDto.getCityNameDto())
                .cityId(cityDto.getCityIdDto())
                .country(cityDto.getCountryDto())
                .build();

        editorial = EditorialEntity.builder()
                .editorialId(editorialDto.getEditorialIdDto())
                .editorialName(editorialDto.getEditorialNameDto())
                .city(city)
                .build();

        editorialRepository.save(editorial);
    }
}