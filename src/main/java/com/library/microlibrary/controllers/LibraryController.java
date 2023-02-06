package com.library.microlibrary.controllers;

import com.library.microlibrary.dto.libraryDto.GetLibraryDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/library")
public class LibraryController {

    @GetMapping(value = "/find/{libraryId}")
    public GetLibraryDto findLibraryById(@PathVariable Integer libraryId){
        GetLibraryDto libraryDto = null;

        return libraryDto;
    }

    @GetMapping(value = "/find-all")
    public List<GetLibraryDto> findLibraryList(){
        List<GetLibraryDto> libraryListDto = null;

        return libraryListDto;
    }

    @PostMapping(value = "/create")
    public String createLibrary(){
        String returnText = null;

        return returnText;
    }

    @PutMapping(value = "/edit/{libraryId}")
    public String editLibrary(){
        String returnText = null;

        return returnText;
    }

}
