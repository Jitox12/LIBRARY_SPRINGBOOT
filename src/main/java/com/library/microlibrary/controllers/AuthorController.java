package com.library.microlibrary.controllers;

import com.library.microlibrary.dto.authorDto.CreateAuthorDto;
import com.library.microlibrary.dto.authorDto.EditAuthorDto;
import com.library.microlibrary.dto.authorDto.GetAuthorDto;
import com.library.microlibrary.services.authorServices.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/author")
public class AuthorController {

    private final AuthorService authorService;
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(value = "/find/{authorId}")
    public GetAuthorDto findAuthorById(@PathVariable Integer authorId){
        GetAuthorDto authorDto = null;
        authorDto = authorService.findAuthorByIdService(authorId);
        return authorDto;
    }
    @GetMapping(value = "/find-all")
    public List<GetAuthorDto> findAuthorList(){
        List<GetAuthorDto> authorDto = null;
        authorDto = authorService.findAuthorListService();
        return authorDto;
    }
    @PostMapping(value="/create")
    public String createAuthor(@RequestBody CreateAuthorDto authorDto){
        authorService.createAuthorService(authorDto);
        return "AUTHOR CREATED";
    }

    @PutMapping(value="/edit/{authorId}")
    public String editAuthor(@PathVariable Integer authorId ,@RequestBody EditAuthorDto authorDto){
        authorService.editAuthorService(authorDto, authorId);
        return "AUTHOR EDITED";
    }
}