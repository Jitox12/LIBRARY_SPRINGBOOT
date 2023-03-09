package com.library.microlibrary.services.editorialServices;

import com.library.microlibrary.dao.cityDao.CityDao;
import com.library.microlibrary.dao.editorialDao.EditorialDao;
import com.library.microlibrary.dto.cityDto.GetCityCountryDto;
import com.library.microlibrary.dto.editorialDto.CreateEditorialDto;
import com.library.microlibrary.dto.editorialDto.EditEditorialDto;
import com.library.microlibrary.dto.editorialDto.GetEditorialDto;
import com.library.microlibrary.entities.CityEntity;
import com.library.microlibrary.entities.EditorialEntity;
import com.library.microlibrary.exceptionsConfig.exceptions.BadRequestException;
import com.library.microlibrary.mappers.cityMappers.CityEntityToGetCityCountryDtoMapper;
import com.library.microlibrary.mappers.editorialMappers.EditorialEntityToGetEditorialDtoMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EditorialServiceImpl implements EditorialService{

    //DAO
    private final EditorialDao editorialDao;
    private final CityDao cityDao;

    //MAPPERS
    private final EditorialEntityToGetEditorialDtoMapper editorialEntityToGetEditorialDtoMapper;
    private final CityEntityToGetCityCountryDtoMapper cityEntityToGetCityCountryDtoMapper;

    public EditorialServiceImpl(EditorialDao editorialDao, CityDao cityDao, EditorialEntityToGetEditorialDtoMapper editorialEntityToGetEditorialDtoMapper, CityEntityToGetCityCountryDtoMapper cityEntityToGetCityCountryDtoMapper) {
        this.editorialDao = editorialDao;
        this.cityDao = cityDao;
        this.editorialEntityToGetEditorialDtoMapper = editorialEntityToGetEditorialDtoMapper;
        this.cityEntityToGetCityCountryDtoMapper = cityEntityToGetCityCountryDtoMapper;
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
            editorialDto = editorialEntityToGetEditorialDtoMapper.editorialEntityToGetEditorialDto(editorial);

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
            editorialListDto = editorial.stream().map(editorialEntityToGetEditorialDtoMapper::editorialEntityToGetEditorialDto).collect(Collectors.toList());

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
            cityDto = cityEntityToGetCityCountryDtoMapper.cityEntityToGetCityDto(city);

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

            cityDto = cityEntityToGetCityCountryDtoMapper.cityEntityToGetCityDto(city);

            editorialDao.editEditorialDao(editorialDto, cityDto);

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
