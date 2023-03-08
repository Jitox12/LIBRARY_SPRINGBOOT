package com.library.microlibrary.controllers;

import com.library.microlibrary.dto.libraryDto.CreateLibraryDto;
import com.library.microlibrary.dto.libraryDto.EditLibraryDto;
import com.library.microlibrary.dto.libraryDto.GetLibraryDto;
import com.library.microlibrary.services.libraryServices.LibraryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/library")
public class LibraryController {


    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping(value = "/find/{libraryId}")
    public GetLibraryDto findLibraryById(@PathVariable Integer libraryId){
        GetLibraryDto libraryDto = null;
        libraryDto = libraryService.findLibraryByIdService(libraryId);
        return libraryDto;
    }

    @GetMapping(value = "/find-all")
    public List<GetLibraryDto> findLibraryList(){
        List<GetLibraryDto> libraryListDto = null;
        libraryListDto = libraryService.findLibraryListService();
        return libraryListDto;
    }

    @PostMapping(value = "/create")
    public String createLibrary(@RequestBody CreateLibraryDto libraryDto){
        libraryService.createLibraryService(libraryDto);
        return "LIBRARY CREATED";
    }

    @PutMapping(value = "/edit/{libraryId}")
    public String editLibrary(@PathVariable Integer libraryId, @RequestBody EditLibraryDto libraryDto){
        libraryService.editLibraryService(libraryDto, libraryId);
        return "LIBRARY EDITED";
    }

}
