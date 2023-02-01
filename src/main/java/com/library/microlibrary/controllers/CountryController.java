package com.library.microlibrary.controllers;

import com.library.microlibrary.dto.countryDto.CreateCountryDto;
import com.library.microlibrary.dto.countryDto.GetCountryDto;
import com.library.microlibrary.dto.countryDto.GetCountryNameDto;
import com.library.microlibrary.services.countryServices.CountryService;
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

    @GetMapping(value = "/find-all-name")
    public List<GetCountryNameDto> findCountryNameList() {
        List<GetCountryNameDto> getCountryList = null;
        getCountryList = countryService.findCountryNameListService();

        return getCountryList;
    }

    @PostMapping(value = "/create")
    public String CreateCountry(@RequestBody CreateCountryDto countryDto) {
        String savedCountryMessage = null;
        savedCountryMessage = countryService.createCountryService(countryDto);

        return savedCountryMessage;
    }
}