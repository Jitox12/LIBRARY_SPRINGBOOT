package com.library.microlibrary.controllers;

import com.library.microlibrary.dto.bookDto.GABookDto;
import com.library.microlibrary.dto.editorialDto.CreateEditorialDto;
import com.library.microlibrary.dto.editorialDto.EditEditorialDto;
import com.library.microlibrary.dto.editorialDto.GetEditorialDto;
import com.library.microlibrary.services.EditorialService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/editorial")
public class EditorialController {

    //Services
    private final EditorialService editorialService;
    @GetMapping(value = "/find/{editorialId}")
    public GetEditorialDto findEditorialById(@PathVariable Integer editorialId){
        GetEditorialDto editorialDto = null;
        editorialDto = editorialService.findEditorialByIdService(editorialId);

        return editorialDto;
    }
    @GetMapping(value = "/find-all")
    public List<GetEditorialDto> findEditorialList(){
        List<GetEditorialDto> editorialListDto = null;
        editorialListDto = editorialService.findEditorialListService();

        return editorialListDto;
    }

    @PostMapping(value = "/create")
    public String createEditorial(@RequestBody CreateEditorialDto editorialDto){
        editorialService.createEditorialService(editorialDto);
        return "EDITORIAL CREATED";
    }
    @PostMapping(value="/create/editorialbook/{editorialId}")
    public String createBookToLibrary(@PathVariable Integer editorialId, @RequestBody List<GABookDto> bookList){
        editorialService.createBookToEditorialService(editorialId,bookList);
        return "EDITORIAL & BOOK RELATED";
    }

    @PutMapping(value = "/edit/{editorialId}")
    public String editEditorial(@RequestBody EditEditorialDto editorialDto, @PathVariable Integer editorialId){
       editorialService.editEditorialService(editorialDto, editorialId);
        return "EDITORIAL EDITED";
    }


}
