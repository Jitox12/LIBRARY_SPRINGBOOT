package com.library.microlibrary.services.serviceImpl;

import com.library.microlibrary.dao.CityDao;
import com.library.microlibrary.dao.EditorialDao;
import com.library.microlibrary.dto.bookDto.GABookDto;
import com.library.microlibrary.dto.cityDto.GetCityCountryDto;
import com.library.microlibrary.dto.editorialDto.CreateEditorialDto;
import com.library.microlibrary.dto.editorialDto.EditEditorialDto;
import com.library.microlibrary.dto.editorialDto.GetEditorialDto;
import com.library.microlibrary.entities.CityEntity;
import com.library.microlibrary.entities.EditorialEntity;
import com.library.microlibrary.exceptionsConfig.exceptions.BadRequestException;
import com.library.microlibrary.mappers.CityMappers;
import com.library.microlibrary.mappers.EditorialMappers;
import com.library.microlibrary.services.EditorialService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EditorialServiceImpl implements EditorialService {

    //DAO
    private final EditorialDao editorialDao;
    private final CityDao cityDao;

    //MAPPERS
    private final EditorialMappers editorialMappers;
    private final CityMappers cityMappers;

    public EditorialServiceImpl(EditorialDao editorialDao, CityDao cityDao, EditorialMappers editorialMappers, CityMappers cityMappers) {
        this.editorialDao = editorialDao;
        this.cityDao = cityDao;
        this.editorialMappers = editorialMappers;
        this.cityMappers = cityMappers;
    }


    @Override
    public GetEditorialDto findEditorialByIdService(Integer editorialId) {
        EditorialEntity editorial;
        GetEditorialDto editorialDto;

        try{
            editorial = editorialDao.findEditorialByIdDao(editorialId);
            if(Objects.isNull(editorial)){
                throw new BadRequestException("Editorial does not exist with Id: "
                        .concat(String.valueOf(editorialId)));
            }
            editorialDto = editorialMappers.editorialEntityToGetEditorialDto(editorial);

            return editorialDto;

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<GetEditorialDto> findEditorialListService() {
        List<EditorialEntity> editorial = null;
        List<GetEditorialDto> editorialListDto = null;
        try{
            editorial = editorialDao.findEditorialListDao();
            editorialListDto = editorial.stream().map(editorialMappers::editorialEntityToGetEditorialDto).collect(Collectors.toList());

            return editorialListDto;
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createEditorialService(CreateEditorialDto editorialDto) {
        CityEntity city = null;
        GetCityCountryDto cityDto = null;

        try {
            city = cityDao.findCityByIdDao(editorialDto.getCityIdDto());
            if(Objects.isNull(city)){
                throw new BadRequestException("City does not exist with Id: ".concat(String.valueOf(editorialDto.getCityIdDto())));
            }
            cityDto = cityMappers.cityEntityToGetCityCountryDto(city);

            editorialDao.createEditorialDao(editorialDto, cityDto);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void editEditorialService(EditEditorialDto editorialDto, Integer editorialId) {
        CityEntity city = null;
        GetCityCountryDto cityDto = null;

        try {
            editorialDto.setEditorialIdDto(editorialId);

            city = cityDao.findCityByIdDao(editorialDto.getCityIdDto());
            if(Objects.isNull(city)){
                throw new BadRequestException("City does not exist with Id: ".concat(String.valueOf(editorialDto.getCityIdDto())));
            }

            cityDto = cityMappers.cityEntityToGetCityCountryDto(city);

            editorialDao.editEditorialDao(editorialDto, cityDto);

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createBookToEditorialService(Integer editorialId, List<GABookDto> bookList) {
        EditorialEntity editorial = null;
        try{
            editorial = editorialDao.findEditorialByIdDao(editorialId);
            if(Objects.isNull(editorial)){
                throw new BadRequestException("Editorial does not exist with id: ".concat(String.valueOf(editorialId)));
            }
            editorialDao.createBookToEditorialDao(editorialId,bookList);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
