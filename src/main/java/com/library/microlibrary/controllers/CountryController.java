package com.library.microlibrary.controllers;

import com.library.microlibrary.dto.countryDto.CreateCountryDto;
import com.library.microlibrary.dto.countryDto.EditCountryDto;
import com.library.microlibrary.dto.countryDto.GetCountryNameDto;
import com.library.microlibrary.services.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/country")
public class CountryController {
    private final CountryService countryService;

    @GetMapping(value = "/find-name/{countryId}")
    public GetCountryNameDto findCountryNameById(@PathVariable Integer countryId) {
        GetCountryNameDto countryDto = null;
        countryDto = countryService.findCountryNameByIdService(countryId);
        return countryDto;
    }

    @GetMapping(value = "/find-name-list")
    public List<GetCountryNameDto> findCountryNameList() {
        List<GetCountryNameDto> getCountryList = null;
        getCountryList = countryService.findCountryNameListService();

        return getCountryList;
    }

    @PostMapping(value = "/create")
    public String CreateCountry(@RequestBody CreateCountryDto countryDto) {
        countryService.createCountryService(countryDto);
        return "COUNTRY CREATED";
    }


    @PutMapping(value = "/edit/{countryId}")
    public String EditCountry(@RequestBody EditCountryDto countryDto, @PathVariable Integer countryId) {
        countryService.editCountryService(countryDto, countryId);
        return "COUNTRY EDITED";
    }
}