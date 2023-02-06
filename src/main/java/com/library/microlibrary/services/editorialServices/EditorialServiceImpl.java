package com.library.microlibrary.services.editorialServices;

import com.library.microlibrary.dao.cityDao.CityDao;
import com.library.microlibrary.dao.countryDao.CountryDao;
import com.library.microlibrary.dao.editorialDao.EditorialDao;
import com.library.microlibrary.dto.cityDto.GetCityCountryDto;
import com.library.microlibrary.dto.cityDto.GetCityDto;
import com.library.microlibrary.dto.countryDto.GetCountryDto;
import com.library.microlibrary.dto.editorialDto.CreateEditorialDto;
import com.library.microlibrary.dto.editorialDto.EditEditorialDto;
import com.library.microlibrary.dto.editorialDto.GetEditorialDto;
import com.library.microlibrary.entities.CityEntity;
import com.library.microlibrary.entities.CountryEntity;
import com.library.microlibrary.entities.EditorialEntity;
import com.library.microlibrary.exceptionsConfig.exceptions.BadRequestException;
import com.library.microlibrary.mappers.cityMappers.CityEntityToGetCityCountryDtoMapper;
import com.library.microlibrary.mappers.cityMappers.CityEntityToGetCityDtoMapper;
import com.library.microlibrary.mappers.countryMappers.CountryEntityToGetCountryDtoMapper;
import com.library.microlibrary.mappers.editorialMappers.EditorialEntityToGetEditorialDtoMapper;
import com.library.microlibrary.utils.returnTextUtils.editorialTextUtil.EditorialReturnTextUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EditorialServiceImpl implements EditorialService{

    //DAO
    private final EditorialDao editorialDao;
    private final CityDao cityDao;
    private final CountryDao countryDao;

    //MAPPERS
    private final EditorialEntityToGetEditorialDtoMapper editorialEntityToGetEditorialDtoMapper;
    private final CityEntityToGetCityCountryDtoMapper cityEntityToGetCityCountryDtoMapper;

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
    public String createEditorialService(CreateEditorialDto editorialDto) {
        EditorialEntity savedEditorial = null;
        CityEntity city = null;

        GetCityCountryDto cityDto = null;
        GetEditorialDto savedEditorialDto = null;

        String returnText = null;
        try {
            city = cityDao.findCityByIdDao(editorialDto.getCityIdDto());
            if(Objects.isNull(city)){
                throw new BadRequestException("City does not exist with Id: ".concat(String.valueOf(editorialDto.getCityIdDto())));
            }
            cityDto = cityEntityToGetCityCountryDtoMapper.cityEntityToGetCityDto(city);

            savedEditorial = editorialDao.createEditorialDao(editorialDto, cityDto);
            savedEditorialDto = editorialEntityToGetEditorialDtoMapper.editorialEntityToGetEditorialDto(savedEditorial);

            returnText = EditorialReturnTextUtil.createCountryText(savedEditorialDto);

            return returnText;
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public String editEditorialService(EditEditorialDto editorialDto, Integer editorialId) {
        EditorialEntity savedEditorial = null;
        CityEntity city = null;

        GetCityCountryDto cityDto = null;
        GetEditorialDto editedEditorialDto = null;

        String returnText = null;
        try {
            editorialDto.setEditorialIdDto(editorialId);

            city = cityDao.findCityByIdDao(editorialDto.getCityIdDto());
            if(Objects.isNull(city)){
                throw new BadRequestException("City does not exist with Id: ".concat(String.valueOf(editorialDto.getCityIdDto())));
            }

            cityDto = cityEntityToGetCityCountryDtoMapper.cityEntityToGetCityDto(city);

            savedEditorial = editorialDao.editEditorialDao(editorialDto, cityDto);
            editedEditorialDto = editorialEntityToGetEditorialDtoMapper.editorialEntityToGetEditorialDto(savedEditorial);

            returnText = EditorialReturnTextUtil.createCountryText(editedEditorialDto);

            return returnText;
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
