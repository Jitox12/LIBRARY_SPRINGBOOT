package com.library.microlibrary.controllers;

import com.library.microlibrary.dto.cityDto.CreateCityDto;
import com.library.microlibrary.dto.cityDto.EditCityDto;
import com.library.microlibrary.dto.cityDto.GetCityNameDto;
import com.library.microlibrary.services.CityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/city")
public class CityController {

    private final CityService cityService;

    @GetMapping(value = "/find-name/{cityId}")
    public GetCityNameDto findCityNameById(@PathVariable Integer cityId) {
        GetCityNameDto cityNameDto = null;
        cityNameDto = cityService.findCityNameByIdService(cityId);

        return cityNameDto;
    }

    @GetMapping(value = "/find-name-list")
    public List<GetCityNameDto> findCityNameListById() {
        List<GetCityNameDto> cityNameListDto = null;
        cityNameListDto = cityService.findCityNameListService();

        return cityNameListDto;
    }

    @PostMapping(value = "/create")
    public String createCity(@RequestBody CreateCityDto cityDto) {
        cityService.createCityService(cityDto);
        return "CITY CREATED";
    }

    @PutMapping(value = "/edit/{cityId}")
    public String editCity(@PathVariable Integer cityId, @RequestBody EditCityDto cityDto) {
        cityService.editCityService(cityDto, cityId);
        return "CITY EDITED";
    }
}